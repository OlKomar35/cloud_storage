package com.komar_olga.cloud;

import com.komar_olga.cloud.model.AbstractMessage;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

import java.io.IOException;
import java.net.Socket;


public class Network {
    private static Socket socket;
    private static final String HOST = "localhost";
    private static final int PORT = 8189;
    private static ObjectEncoderOutputStream out;
    private static ObjectDecoderInputStream in;


    public static void start() {
        try {
            socket = new Socket(HOST, PORT);
            out=new ObjectEncoderOutputStream(socket.getOutputStream());
            in=new ObjectDecoderInputStream(socket.getInputStream());
            System.out.println("Клиент подключился");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void stop(){
        try{
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean sendMsg(AbstractMessage msg){
        try{
            out.writeObject(msg);
            out.flush();
            return true;

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


    public static AbstractMessage readObject() throws ClassNotFoundException,IOException{
        Object obj=in.readObject();
        return (AbstractMessage) obj;
    }

}

