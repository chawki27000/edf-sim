package main;

import simulation.AbstractEvent;
import simulation.AbstractSimulator;
import simulation.Comparable;

public class Event extends AbstractEvent {

    int time;
    Task tau;
    EventType event_type;

    public Event(int time, Task tau, EventType event_type) {
        this.time = time;
        this.tau = tau;
        this.event_type = event_type;
    }

    @Override
    public void execute(AbstractSimulator simulator) {

    }

    @Override
    public boolean lessThan(Comparable y) {
        Event e = (Event) y;
        return this.time < e.time;
    }
}
