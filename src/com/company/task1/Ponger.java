package com.company.task1;

public class Ponger implements Runnable {

    private PingPongPrinter printer;

    public Ponger(PingPongPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.pong();
    }
}
