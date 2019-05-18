package PriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;

public abstract class AbstractPriorityQueue<K extends Comparable<K>, V> {
    // Class Variables //
    /** The container that stores elements and their respective weight */
    private LinkedList<Entry<K, V>> queue;
    /** An optional comparator can be provided to override the comparing method of the key K */
    private Comparator<K> comparator;

    // Constructors //
    public AbstractPriorityQueue() {
        queue = new LinkedList<>();
    }

    public AbstractPriorityQueue(Comparator<K> comparator) {
        this();
        this.comparator = comparator;
    }

    // Methods //
    protected LinkedList<Entry<K, V>> getQueue() {
        return queue;
    }

    /**
     * Determines the how many elements is in the queue.
     * @return the size of the queue.
     */
    public int size() {
        return queue.size();
    }

    /**
     * Returns if the queue is empty or not.
     * @return true if no elements currently in the queue, else false
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Insert element V into the queue with its respective weight K
     * @param key the weight of the value
     * @param value the value to be stored
     * @return true if the key and value pair has been stored into the queue.
     */
    public abstract boolean insert(K key, V value);

    /**
     * Removes and returns the value V that has the least priority (or weight) using the Comparator
     * provided during constructor initialization, or compareTo() method from the Comparable key K
     * if no Comparator was provided.
     * @return the value V that has the least weight / priority.
     */
    public abstract V removeMin();

    /**
     * Retrieve the value V that has the least priority (or weight) using the Comparator
     * provided during constructor initialization, or compareTo() method from the Comparable key K
     * if no Comparator was provided. Does not remove the element from the queue.
     * @return the value V that has the least weight / priority.
     */
    public abstract V min();

    /**
     * Removes and returns the value V that has the most priority (or weight) using the Comparator
     * provided during constructor initialization, or compareTo() method from the Comparable key K
     * if no Comparator was provided.
     * @return the value V that has the most weight / priority.
     */
    public abstract V removeMax();

    /**
     * Retrieve the value V that has the most priority (or weight) using the Comparator
     * provided during constructor initialization, or compareTo() method from the Comparable key K
     * if no Comparator was provided. Does not remove the element from the queue.
     * @return the value V that has the most weight / priority.
     */
    public abstract V max();

    /**
     * Compares the keys K key1 and K key2. If a Comparator was provided during initialization
     * then the Comparator will be used for comparison, otherwise Comparable K key1 and and K key will be compared.
     * @param key1 the comparing key
     * @param key2 the comparer key
     * @return -1 if key1 is smaller than key2, 0 if key1 is equal to key2, 1 if key1 is greater than key2.
     */
    public int compare(K key1, K key2) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        } else {
            return key1.compareTo(key2);
        }
    }
}
