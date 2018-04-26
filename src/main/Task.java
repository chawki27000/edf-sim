package main;

public class Task {

    private int c; // Computation time
    private int d; // Relative deadline
    private int t; // Period of a task

    public Task(int t, int c, int d) {
        this.t = t;
        this.c = c;
        this.d = d;
    }

    public int getT() {
        return t;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

}
