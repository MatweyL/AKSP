package com.company.task2.server;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends SquareEquationSolver {

    public Server() {}

    public static void main(String[] args) {
        try {
            SquareEquationSolver squareEquationSolver = new SquareEquationSolver();
            Registry registry = LocateRegistry.createRegistry(5555);
            Remote stub = UnicastRemoteObject.exportObject(squareEquationSolver, 0);
            registry.bind("Solver", stub);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

}
