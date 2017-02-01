package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Danya on 31/01/2017.
 */
public class Server {

    private static Map<String,Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter port:");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){
            ConsoleHelper.writeMessage("Server is started");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends  Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connection with remote address " + socket.getRemoteSocketAddress() + " success.");
            String name = null;
            try (Connection connection = new Connection(socket)){
                ConsoleHelper.writeMessage("Подключение к порту: "+connection.getRemoteSocketAddress());
                name =serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,name));
                sendListOfUsers(connection,name);
                serverMainLoop(connection,name);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error with data");
            }

            connectionMap.remove(name);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            ConsoleHelper.writeMessage("Connection with remote address "+socket.getRemoteSocketAddress()+" closed.");


        }

        private String serverHandshake(Connection connection) throws IOException,ClassNotFoundException{
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(message.getType() == MessageType.USER_NAME) {
                    String name = message.getData();
                    if (name != null && !name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }
        private void sendListOfUsers(Connection connection, String userName)throws IOException
        {
            for(Map.Entry<String,Connection> pair : connectionMap.entrySet())
            {
                if(pair.getKey()!=userName)
                {
                    connection.send(new Message(MessageType.USER_ADDED,pair.getKey()));
                }
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while(true)
            {
                Message message = connection.receive();
                if(message.getType()==MessageType.TEXT)
                {
                    sendBroadcastMessage(new Message(MessageType.TEXT,String.format("%s: %s",userName,message.getData())));
                }
                else{
                    ConsoleHelper.writeMessage("Error: not text");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String,Connection> connectionEntry : connectionMap.entrySet()){
            try {
                connectionEntry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Can't send message");
            }
        }
    }
}
