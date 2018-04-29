package simulation;

public abstract class AbstractEvent implements Comparable{

    public abstract void execute(AbstractSimulator simulator);
}
