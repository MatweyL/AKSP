package com.company.task2.data;

import java.io.Serializable;
import java.util.List;

public class Solution implements Serializable {

    final private boolean hasSolution;
    final private boolean hasInfinitySolutions;
    final private List<Double> solutions;

    public boolean isHasSolution() {
        return hasSolution;
    }

    public boolean isHasInfinitySolutions() {
        return hasInfinitySolutions;
    }

    public List<Double> getSolutions() {
        return solutions;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "hasSolution=" + hasSolution +
                ", hasInfinitySolutions=" + hasInfinitySolutions +
                ", solutions=" + solutions +
                '}';
    }

    public Solution(boolean hasSolution, boolean hasInfinitySolutions, List<Double> solutions) {
        this.hasSolution = hasSolution;
        this.hasInfinitySolutions = hasInfinitySolutions;
        this.solutions = solutions;
    }
}
