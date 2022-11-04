package com.company.task2;

import java.util.ArrayList;
import java.util.List;

public class SquareEquationSolver {


    public Solution getSolution(Coefficients coefficients) {
        double a = coefficients.getA();
        double b = coefficients.getB();
        double c = coefficients.getC();
        if (a != 0) {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                return new Solution(false, false, null);
            } else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                if (d == 0) {
                    return new Solution(true, false, new ArrayList<>(List.of(x1)));
                } else {
                    return new Solution(true, false, new ArrayList<>(List.of(x1, x2)));
                }
            }
        } else {
            if (b != 0) {
                double x = -c / b;
                return new Solution(true, false,  new ArrayList<>(List.of(x)));
            } else {
                if (c == 0) {
                    return new Solution(true, true, null);
                }
                return new Solution(false, false,null);
            }
        }
    }

}
