package main;

import simulation.AbstractSimulator;

public class Simulator extends AbstractSimulator {

    int MaxSimTime;
    static int similatorClock;
    EDF edf;

    public Simulator(int MaxSimTime) {
        similatorClock = 0;
        this.MaxSimTime = MaxSimTime;
        edf = new EDF();
    }

    public int simulate() {
        while (!eventList.isEmpty() && similatorClock < MaxSimTime) {

            Event curr_ev = (Event) eventList.removeFirst();
            similatorClock = curr_ev.time;

            switch (curr_ev.event_type) {

                case TASK_ARRIVAL:
                    edf.task_arrival(curr_ev);
                    break;

                case TASK_DEADLINE:
                    edf.task_deadline(curr_ev);
                    break;

                case TASK_FINISHED:
                    edf.task_finished(curr_ev);
                    break;

                default:
                    break;
            }
        }

        return 0;
    }
}
