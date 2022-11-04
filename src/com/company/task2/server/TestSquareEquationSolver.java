package com.company.task2.server;

import com.company.task2.data.Coefficients;

import java.rmi.RemoteException;

public class TestSquareEquationSolver {

    public static void main(String[] args) {
        SquareEquationSolver s = new SquareEquationSolver();
        try {
            System.out.println(s.getSolution(new Coefficients(0, 0, 0)));
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }
}
