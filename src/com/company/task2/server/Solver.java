package com.company.task2.server;

import com.company.task2.data.Coefficients;
import com.company.task2.data.Solution;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Solver extends Remote {

    Solution getSolution(Coefficients coefficients) throws RemoteException;

}
