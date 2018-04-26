package main;

public class Main {

    public static void main(String[] args) {

        int hyperperiod;

        // Task Creation and TaskSet Filling
        Task ts1 = new Task(6, 2, 5);
        Task ts2 = new Task(8, 2, 4);
        Task ts3 = new Task(12, 4, 8);

        TaskSet taskSet = new TaskSet();
        taskSet.addTask(ts1);
        taskSet.addTask(ts2);
        taskSet.addTask(ts3);

        // HyperPeriod Computation
        hyperperiod = taskSet.getHyperPeriod();

        System.out.println("hyperperiod : "+hyperperiod);
    }
}
