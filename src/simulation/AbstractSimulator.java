package simulation;

public class AbstractSimulator {
    public static OrderedSet eventList;

    public void insert(AbstractEvent e) {
        eventList.insert(e);
    }
}
