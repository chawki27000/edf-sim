package main;

import java.util.LinkedList;
import java.util.Queue;

public class Event {

    private Queue<EventType> eventQueue;

    public Event() {
        eventQueue = new LinkedList<>();
    }

    public void push(EventType eventType) {
        eventQueue.add(eventType);
    }

    public EventType pop() {
        return eventQueue.poll();
    }

    public boolean isEmpty() {
        return eventQueue.isEmpty();
    }
}
