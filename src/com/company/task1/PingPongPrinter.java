package com.company.task1;

public class PingPongPrinter {

    private final String PING = "PING";
    private final String PONG = "PONG";
    private Boolean print_ping = true   ;

    public synchronized void ping() {
        for (int i = 0; i < 3; i++) {
            while (!print_ping) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                System.out.println("PING");
                print_ping = !print_ping;
                notify();

        }
    }

    public synchronized void pong() {
        for (int i = 0; i < 3; i++) {
            while (print_ping) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                System.out.println("PONG");
                print_ping = !print_ping;
                notify();


        }
    }

}