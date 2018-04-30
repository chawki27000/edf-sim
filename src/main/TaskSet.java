package main;

import java.util.ArrayList;

public class TaskSet {

    ArrayList<Task> tasks;

    public TaskSet() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task ts) {
        tasks.add(ts);
    }


    public int getHyperPeriod() {
        int hyperperiod = 1;

        for (Task ts : tasks) {
            hyperperiod = lcm(hyperperiod, ts.getT());
        }

        return hyperperiod;
    }

    private int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        int remainder = 0;
        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (b != 0);

        return a;
    }


}
