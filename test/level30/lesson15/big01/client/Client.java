package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Danya on 01/02/2017.
 */
public class Client {
    protected Connection connection;
    private volatile  boolean clientConnected = false;

    public class SocketThread extends Thread {

        @Override
        public void run() {
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void processIncomingMessage(String message) throws IOException {
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("New member %s connected",userName));
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Member %s has left chat",userName));
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME,name));
                }
                else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else{
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ups something go wrong...");
            return;
        }
        if(clientConnected){
            ConsoleHelper.writeMessage("Connection success for exit enter 'exit'");
            while(clientConnected){
                String text = ConsoleHelper.readString();
                if(!text.equalsIgnoreCase("exit")&& shouldSentTextFromConsole()){
                    sendTextMessage(text);
                }
                else{
                    break;
                }
            }
        }
        else {
            ConsoleHelper.writeMessage("Error client runtime");
            return;
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Enter address to connection^");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter server port:");
        return  ConsoleHelper.readInt();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter username:");
        return  ConsoleHelper.readString();
    }
    protected boolean shouldSentTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ups something go wrong....");
            clientConnected = false;
        }
    }
}
