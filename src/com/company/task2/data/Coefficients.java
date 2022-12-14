package com.company.task2.data;

import java.io.Serializable;

public class Coefficients implements Serializable {

    final private double a;
    final private double b;
    final private double c;

    public Coefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
