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

        int absDeadline = 2147483647;
        Task ts = null;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isTerminated())
                System.out.println("Task " + tasks.get(i).getId() + " Is TERMINATED");

            if (tasks.get(i).getAbsDeadline() < absDeadline
                    && !tasks.get(i).isTerminated()) {
                absDeadline = tasks.get(i).getAbsDeadline();
                ts = tasks.get(i);
            }
        }
        return ts;

    }

    public boolean taskReleased(int clock) {
//        System.out.println("CALL - taskReleased");
        for (Task ts : tasks) {
            if (clock % ts.getT() == 0 && ts.isTerminated()) {
                ts.instanceInc();
                System.out.println("RELEASE -- " + ts.toString() + " Released at : " + clock);
                Main.event.push(EventType.TASK_SELECTION);
                return true;
            }
        }

        return false;
    }
}
