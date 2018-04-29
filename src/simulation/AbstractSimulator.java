package simulation;

public class AbstractSimulator {
    protected OrderedSet events;

    public void insert(AbstractEvent e) {
        events.insert(e);
    }
}
