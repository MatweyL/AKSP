package com.company.task1;

public class Pinger implements Runnable {

    private PingPongPrinter printer;

    public Pinger(PingPongPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.ping();
    }
}
