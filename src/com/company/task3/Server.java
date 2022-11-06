package com.company.task3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Server {

    private ServerSocket serverSocket;
    private List<String> messages = Collections.synchronizedList(new ArrayList<>());
    private List<ClientHandler> connections = new ArrayList<>();


    public Server() {
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("server is running on port " + port);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sendMessages();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        while (true) {
            ClientHandler connection = new ClientHandler(serverSocket.accept(), messages);
            System.out.println("server accepted new connection");
            connections.add(connection);
            connection.start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private void sendMessages() {
        if (!messages.isEmpty()) {
            for (String message: messages) {
                for (ClientHandler connection: connections) {
                    connection.getOut().println(message);
                }
            }
            messages.clear();
        }
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        try {
            server.start(5555);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }

    }


}
