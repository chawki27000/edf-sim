package main;


public class Job {

    private Task tau;
    private int arrival_time;
    private int deadline;
    private int remaing;
    int s;

    public Job(Task tau, int arrival_time) {
        this.tau = tau;
        this.arrival_time = arrival_time;
        deadline = tau.getD();
        remaing = tau.getC();
    }

    public Task getTau() {
        return tau;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public int getDeadline() {
        return deadline;
    }

    public int getRemaing() {
        return remaing;
    }

    public void setRemaing(int remaing) {
        this.remaing = remaing;
    }
}
