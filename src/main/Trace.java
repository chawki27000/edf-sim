package main;

public class Trace {

    Job job;
    int start, end;

    public Trace(Job job, int start, int end) {
        this.job = job;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task : " + job.getTau().getId() + ", Arrival time : " + job.getArrival_time() +
                ", Sched : " + start + ", Desched : " + end;
    }
}
