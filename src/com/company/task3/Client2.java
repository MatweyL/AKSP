package com.company.task3;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client2 {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public void startConnection(String ip, int port, String name) throws IOException {
        clientSocket = new Socket(ip, port);
        clientName = "[client_" + name + "]: ";
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void startCommunication() throws IOException {
        Thread messagesGettingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = null;
                while (true) {
                    try {
                        message = getMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (!Objects.equals(message, "") && message != null) {
                        System.out.println(message);
                    }
                }
            }
        });
        messagesGettingThread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String message = reader.readLine();
            if (message.equals("EXIT")) {
                sendMessage("exited from chat!");
                break;
            }
            sendMessage(message);
        }
        messagesGettingThread.interrupt();
    }

    public void sendMessage(String message) {
        out.println(clientName + message);
    }

    public String getMessage() throws IOException {
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Your name: ");
        String name = reader.nextLine();
        Client client = new Client();
        client.startConnection("127.0.0.1", 5555, name);
        client.startCommunication();
        client.stopConnection();
    }
}
