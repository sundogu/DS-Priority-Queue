package PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;

public abstract class AbstractPriorityQueue<K extends Comparable<K>, V> {
    // Class Variables //
    protected LinkedList<Entry<K, V>> queue;
    protected Comparator<K> comparator;

    // Constructors //
    public AbstractPriorityQueue() {
        queue = new LinkedList<>();
    }

    public AbstractPriorityQueue(Comparator<K> comparator) {
        this();
        this.comparator = comparator;
    }

    // Methods //
    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public abstract boolean insert(K key, V value);

    public abstract V removeMin();

    public abstract V min();

    public abstract V removeMax();

    public abstract V max();
}
