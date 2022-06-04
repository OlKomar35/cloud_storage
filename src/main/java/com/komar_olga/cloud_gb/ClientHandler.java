package com.komar_olga.cloud_gb;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private static final List<Channel> channels = new ArrayList<>();
    private String clientName, login, pass;
    private static int newClientIndex = 1;
    private static ObjectEncoderOutputStream out;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof FileRequest) {
            FileRequest fr = (FileRequest) msg;
//            System.out.println(fr.getFileName());
//            System.out.println(fr.getActionPoint());
            if (fr.getActionPoint().equals("list")) {
                ctx.writeAndFlush(new FileList("server_storage/"));
            } else {
                if (fr.getFileName() != null) {
                    if (Files.exists(Paths.get("server_storage/" + fr.getFileName()))) {
                        if (fr.getActionPoint().equals("delete")) {
                            Path path = Paths.get("server_storage/" + fr.getFileName());
                            Files.delete(path);
                        }
                        if (fr.getActionPoint().equals("download")) {
                            FileMessage fm = new FileMessage(Paths.get("server_storage/" + fr.getFileName()), "download");
                            ctx.writeAndFlush(fm);
                        }
                        // todo не верно , нужно переделать
                        if (fr.getActionPoint().startsWith("rename")) {
                            Path sourcePath = null, destinationPath;
                            if (fr.getActionPoint().equals("rename_first")) {
                                sourcePath = Paths.get("server_storage/" + fr.getFileName());
                            }
                            if (fr.getActionPoint().equals("rename_second")) {
                                destinationPath = Paths.get("server_storage/" + fr.getFileName());
                                System.out.println(sourcePath.getFileName() + "->" + destinationPath.getFileName());
                                Files.move(sourcePath, destinationPath);
                            }
                            // }
                        }
                    }
                }
            }
        } else {
            if (msg instanceof FileMessage) {
                FileMessage fm = (FileMessage) msg;
                if (fm.getActionPoint().equals("upload")) {
                    Files.write(Paths.get("server_storage/" + fm.getFileName()), fm.getData(), StandardOpenOption.CREATE);
                }
            }
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Клиент подключился! " + ctx);
        channels.add(ctx.channel());

    }


}
