package main;

public class Main {

    public static void main(String[] args) {

        Task tau_0 = new Task(0, 10, 5, 11);
        Task tau_1 = new Task(1, 10, 5, 7);

        Event ev_1 = new Event(0, tau_0, EventType.TASK_ARRIVAL);
        Event ev_2 = new Event(15, tau_0, EventType.TASK_ARRIVAL);
        Event ev_3 = new Event(3, tau_1, EventType.TASK_ARRIVAL);
        Event ev_5 = new Event(12, tau_0, EventType.TASK_FINISHED);
        Event ev_6 = new Event(17, tau_0, EventType.TASK_FINISHED);
        Event ev_7 = new Event(6, tau_1, EventType.TASK_FINISHED);

        Simulator.eventList = new EventList();

        Simulator.eventList.insert(ev_1);
        Simulator.eventList.insert(ev_2);
        Simulator.eventList.insert(ev_3);
        Simulator.eventList.insert(ev_5);
        Simulator.eventList.insert(ev_6);
        Simulator.eventList.insert(ev_7);

        System.out.println(Simulator.eventList);

        Simulator s = new Simulator(40);
        s.simulate();

        for (Trace t : s.edf.traces) {
            System.out.println(t);
        }
    }


}
