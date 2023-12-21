package ru.geekbrains.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            StringBuilder users = new StringBuilder();
            for (ClientManager client: clients){
                users.append(client.name + "\n");
            }
            System.out.println(name + " подключился к чату.");
            broadcastMessage("Server: " + name + " подключился к чату. В сети " + clients.size() + " человек\n"
                    + users, name);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    @Override
    public void run() {
        String massageFromClient;

        while (socket.isConnected()) {
            try {
                massageFromClient = bufferedReader.readLine();
                /*if (massageFromClient == null){
                    // для  macOS
                    closeEverything(socket, bufferedReader, bufferedWriter);
                    break;
                }*/
                broadcastMessage(massageFromClient, name);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message, String nameSendUser) {
        if (message.contains("@")) {
            String nameResiver;
            StringBuilder builder = new StringBuilder();
            for (int i = message.indexOf("@")+1; i < message.length(); i++) {
                if (!(message.charAt(i) == ' ')){
                    builder.append(message.charAt(i));
                }else break;
            }
            nameResiver = builder.toString();
            String individualMessage;
            builder.delete(0,builder.length());
            String [] messages = message.split(" ");
            for (int i = 2; i < messages.length; i++) {
                builder.append(messages[i] + " ");
            }
            individualMessage = builder.toString();
            System.out.println("Сообщение - " + individualMessage);
            for (ClientManager client: clients) {
                if ((client.name).equals(nameResiver)){
                    try {
                        client.bufferedWriter.write(nameSendUser + " " + individualMessage);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        } else {
            sendToAll(message);
        }
    }


    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        // Удаление клиента из коллекции
        removeClient();
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Закрытие соединения с клиентским сокетом
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " покинул чат.");
        broadcastMessage("Server: " + name + " покинул чат.", name);
    }

    private void sendToAll(String message) {
        for (ClientManager client : clients) {
            try {
                if (!client.name.equals(name)) {
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }

    }

    public String getName() {
        return name;
    }
}
