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

    public Task taskSelection() {

        int absDeadline = tasks.get(0).getAbsDeadline();

        for (int i = 1; i < tasks.size(); i++) {
            if (tasks.get(i).getAbsDeadline() < absDeadline)
                return tasks.get(i);
        }

        return tasks.get(0);

    }

    public boolean taskReleased(int clock) {
        for (Task ts : tasks) {
            if (clock % ts.getT() == 0) {
                ts.instanceInc();
                System.out.println(ts.toString() + " Released at : " + clock);
                return true;
            }
        }

        return false;
    }
}
