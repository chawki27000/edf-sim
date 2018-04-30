package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EDF {

    ArrayList<Trace> traces = new ArrayList<Trace>();
    ArrayList<Job> activeJobs = new ArrayList<Job>();
    Job curr_job = null;

    public void push(Job j) {
        activeJobs.add(j);

        Collections.sort(activeJobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.getDeadline() > o2.getDeadline())
                    return 1;
                else
                    return -1;
            }
        });
    }

    public void removeJob(Job j) {
        activeJobs.remove(j);
    }

    public Job pickNext() {
        return activeJobs.get(0);
    }

    public int task_arrival(Event ev) {
        Job j = new Job(ev.tau, ev.time);
        push(j);

        // add its Deadline event
        Event e = new Event(j.getDeadline(), j.getTau(), EventType.TASK_DEADLINE);

        Simulator.eventList.insert(e);

        resched();
        return 0;
    }

    public int task_finished(Event ev) {
        Simulator.eventList.remove(ev);
        resched();
        return 0;
    }

    public void task_deadline(Event ev) {
        for (Job j : activeJobs) {
            if (j.getTau().getId() == ev.tau.getId()) {
                System.out.println("Task " + ev.tau.getId()
                        + " Has missed its deadline : " + Simulator.similatorClock);
                return;
            }

            System.out.println("Task " + ev.tau.getId()
                    + " Has not missed its deadline");
            return;
        }
    }

    private void resched() {
        if (curr_job != null) {
            saveContext(curr_job);
            saveTrace();
            curr_job = null;
        }
        if (activeJobs.size() == 0)
            return;

        Job j = pickNext();
        loadContext(j);

        createNewTrace(j);
    }

    private void loadContext(Job j) {
        if (j.s == 0)
            j.s = Simulator.similatorClock;
        curr_job = j;
    }

    private void createNewTrace(Job j) {
        Trace t = new Trace(j, Simulator.similatorClock, -1);
        traces.add(t);
    }

    private void saveTrace() {
        traces.get(traces.size() - 1).end = Simulator.similatorClock;
    }

    private void saveContext(Job curr_job) {
        int new_remaining = curr_job.getRemaing() - Simulator.similatorClock - curr_job.s;
        curr_job.setRemaing(new_remaining);
    }
}
