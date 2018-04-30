package main;

import simulation.Comparable;
import simulation.OrderedSet;

import java.util.ArrayList;

public class EventList extends OrderedSet {

    private ArrayList<Event> eventQueue;

    public EventList() {
        this.eventQueue = new ArrayList<Event>();
    }

    @Override
    public void insert(Comparable x) {
        int i = 0;
        Event e = (Event) x;
        while (i < eventQueue.size() && eventQueue.get(i).lessThan(e)) {
            i++;
        }

        eventQueue.add(i, e);
    }

    @Override
    public Comparable removeFirst() {
        if (eventQueue.size() == 0) return null;

        Comparable x = eventQueue.get(0);
        eventQueue.remove(0);
        return x;

    }

    @Override
    public int size() {
        return eventQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return size() > 0;

    }


    @Override
    public Comparable remove(Comparable x) {
        for (int i = 0; i < eventQueue.size(); i++) {
            if (eventQueue.get(i).equals(x)) {
                Object y = eventQueue.get(i);
                eventQueue.remove(i);
                return (Comparable) y;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "EventQueue : [ ";

        for (Event e : eventQueue) {
            str += "(Time : " + e.time + ", Task : " + e.tau.getId() + ", EventType : " + e.event_type + ")\n";
        }

        str += " ]";

        return str;
    }
}
