package com.company.task1;

public class TestPingPongPrinter {



    public static void main(String[] args) {
        PingPongPrinter printer = new PingPongPrinter();
        Runnable pinger = new Pinger(printer);
        Runnable ponger = new Ponger(printer);
        new Thread(pinger).start();
        new Thread(ponger).start();

    }

}