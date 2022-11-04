package com.company.task2.client;

import com.company.task2.data.Coefficients;
import com.company.task2.data.Solution;
import com.company.task2.server.Solver;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    private Client() {}

    public static void printSolution(Solution solution) {
        if (solution.isHasSolution()) {
            if (solution.isHasInfinitySolutions()) {
                System.out.println("Уравнение имеет бесконечное количество корней");
            } else {
                System.out.println("Уравнение имеет корни");
                List<Double> s = solution.getSolutions();
                for (Double x: s) {
                    System.out.println("x" + (s.indexOf(x) + 1) + " = " + x);
                }
            }
        } else {
            System.out.println("Уравнение не имеет корней");
        }
    }


    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(5555);
            Solver stub = (Solver) registry.lookup("Solver");
            printSolution(stub.getSolution(new Coefficients(5, 12, 4)));
            printSolution(stub.getSolution(new Coefficients(0, 12, 12)));
            printSolution(stub.getSolution(new Coefficients(0, 0, 4)));
            printSolution(stub.getSolution(new Coefficients(0, 0, 0)));
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
