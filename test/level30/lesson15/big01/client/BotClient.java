package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Danya on 01/02/2017.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
       new BotClient().run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)  {
            ConsoleHelper.writeMessage(message);
            String senderName = "";
            String text;
            if (message.contains(": ")) {
                senderName = message.substring(0, message.indexOf(": "));
                text = message.substring(message.indexOf(": ") + 2);
            } else {
                text = message;
            }

            SimpleDateFormat format = null;
            if (text.equalsIgnoreCase("дата")) {
                format = new SimpleDateFormat("d.MM.YYYY");
            } else if (text.equalsIgnoreCase("день")) {
                format = new SimpleDateFormat("d");
            } else if (text.equalsIgnoreCase("месяц")) {
                format = new SimpleDateFormat("MMMM");
            } else if (text.equalsIgnoreCase("год")) {
                format = new SimpleDateFormat("YYYY");
            } else if (text.equalsIgnoreCase("время")) {
                format = new SimpleDateFormat("H:mm:ss");
            } else if (text.equalsIgnoreCase("час")) {
                format = new SimpleDateFormat("H");
            } else if (text.equalsIgnoreCase("минуты")) {
                format = new SimpleDateFormat("m");
            } else if(text.equalsIgnoreCase("секунды")) {
                format = new SimpleDateFormat("s");
            }
            if(format!=null) {
                sendTextMessage("Информация для " + senderName+": "+ format.format(Calendar.getInstance().getTime()));
            }
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+ (int)(Math.random()*99);


    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
}
