<h1 align="center">Облачное хранилище файлов. <br> Реализованная при помощи Java IO, NIO, Netty, StreamAPI+Java FX </h1>
<h2 dir="auto"><a id="user-content-оглавление" class="anchor" aria-hidden="true" href="#оглавление"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"></svg></a>Оглавление</h2>
<ol start="0" dir="auto">
<li><a href="#предисловие">Предисловие</a></li>
<li><a href="сервер">Модуль Server</a></li>
<li><a href="клиент">Модуль Client</a></li>
<li><a href="модель">Модуль Model</a></li>
<li><a href="#дополнение">Дополнения</a></li>
</ol>

<h2 dir="auto"><a id="предисловие" class="anchor" aria-hidden="true" href="#предисловие"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"></svg></a>Предисловие</h2>

<b>В рамках проекта реализованно:</b>
<ul dir="auto">
<li><b>Сервер Netty</b> запускается и подключает клиентов, пересылает служебные сообщения от клиентов (котороые так же могут нести в себе данные из файла), отвечает за авторизацию пользователей, использует <code>Data Base SQLite</code>, для хранения данных пользователей (работа с Data Base через <code>JDBC</code>), распределяет и контроллирует выделяемое под пользователей дисковое пространство, по запросу от клиентов проводит действия на закрепленном  за пользователем дисковом пространстве.</li>
<li><b>Клиент Java FX</b> запускаясь предлагает пользователю авторизоваться и при успехе предоставляет доступ к основному графическому интерфейсу <code>(GUI)</code>. <code>GUI</code> показывает состояние хранилища для пользователя: наличие файлов и их свойства, общую наполненность до <code>10 Gb</code> (это размер дискогвого пространства, выделяемого каждому пользователю на сервере). Так же <code>GUI</code> содержит элементы управления позволяющие выполнять следующие действия.
<ul dir="auto">
<li>Принять и записать файлы пользователя.</li>
<li>Передать файлы пользователю.</li>
<li>Удалить файлы с дискового пространства пользователя.</li>
</ul>
</li>
</ul>

<blockquote>
 <p dir="auto"><b>Техническая часть:</b></p>
</blockquote>

<ul dir="auto">
<li><code>IDE: IntelliJ IDEA 2021.3.3</code></li>
<li><code>Версия JDK: 1.8.0_121 + 16 на стороне клиента.</code></li>
<li><code>Netty Framework</code></li>
<li><code>SQLite</code></li>
</ul>

<blockquote>
 <p dir="auto"><b>Используемые технологии:</b></p>
</blockquote>

<ul dir="auto">
<li><code>Java FX</code></li>
<li><code>Java IO, NIO</code></li>
<li><code>Stream API</code></li>
<li><code>Netty</code></li>
<li><code>CSS</code></li>
<li><code>JDBC</code></li>
<li><code>Мавен 3.5</code></li>
</ul>

![Image for project](https://github.com/OlKomar35/shulte_table/blob/master/images_for_project/shulte%20(2).gif)

<a href="#оглавление"><g-emoji class="g-emoji" alias="arrow_up" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/2b06.png">⬆️</g-emoji>Оглавление</a>

<h2 dir="auto"><a id="логика" class="anchor" aria-hidden="true" href="#предисловие"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"></svg></a>Логика приложения</h2>

<p>   Логика данного проекта проработана таким образом, что пк не делает ход рандомно, а просчитывает ходы, пытается не дать выйграть игроку и пытается выйграть сам. 
В методе "Ход компьютера" проверяются все варианты победы компьютера и все возможные блокировки играка.<br> На блок-схеме показанно только один вариант проверки, это проверка строк на количество нулей, для победы компьютера</p>



![Image block diagram](https://github.com/OlKomar35/shulte_table/blob/master/images_for_project/shulte_diagram.png)

<a href="#оглавление"><g-emoji class="g-emoji" alias="arrow_up" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/2b06.png">⬆️</g-emoji>Оглавление</a>

<h2 dir="auto"><a id="дополнение" class="anchor" aria-hidden="true" href="#дополнение"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"></svg></a>
Дополнение</h2>

<h3>Меню программы</h3>

![Image for project](https://github.com/OlKomar35/shulte_table/blob/master/images_for_project/screen5.jpg)

<h3>Три уровня сложности</h3>
<p> На данном этапе реализованн один уровень сложности, от 1 до 25 (leval easy)</p>

![Image for project](https://github.com/OlKomar35/shulte_table/blob/master/images_for_project/screen4.jpg)

<h3>Вывод результата</h3>

![Image for project](https://github.com/OlKomar35/shulte_table/blob/master/images_for_project/screen3.jpg)

<a href="#оглавление"><g-emoji class="g-emoji" alias="arrow_up" fallback-src="https://github.githubassets.com/images/icons/emoji/unicode/2b06.png">⬆️</g-emoji>Оглавление</a>

