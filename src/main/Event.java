package main;

import java.util.LinkedList;
import java.util.Queue;

public class Event {

    private Queue<EventType> eventQueue;

    public Event() {
        eventQueue = new LinkedList<>();
    }
}
