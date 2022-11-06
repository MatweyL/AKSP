package com.company.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {

    final private Socket clientSocket;
    private List<String> serverMessages;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket, List<String> serverMessages) {
        this.clientSocket = clientSocket;
        this.serverMessages = serverMessages;
    }

    public PrintWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while (true) {
                message = in.readLine();
                serverMessages.add(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out.close();
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
