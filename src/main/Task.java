package main;

public class Task {

    private int id;
    private int c; // Computation time
    private int d; // Relative deadline
    private int t; // Period of a task
    private int j; // j instance of a task

    // preemptive Context
    private int progression;

    public Task(int id, int t, int c, int d) {
        this.id = id;
        this.t = t;
        this.c = c;
        this.d = d;
        j = 0;
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

    public void instanceInc() {
        j++;
        progression = 0;
    }

    public boolean progres() {
        progression++;
        return progression == c;
    }

    public int getAbsDeadline() {
        return (j - 1) * t + d;
    }

    @Override
    public String toString() {
        return "Task " + id;
    }
}
