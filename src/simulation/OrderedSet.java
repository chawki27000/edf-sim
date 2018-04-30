package simulation;

public abstract class OrderedSet {
    public abstract void insert(Comparable x);
    public abstract Comparable removeFirst();
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract Comparable remove(Comparable x);
}
