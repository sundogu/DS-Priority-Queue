package PriorityQueue;

public class Entry<K, V> {
    // Class Variables //
    /** The key used for comparison */
    private K key;
    /** The value to store */
    private V value;

    // Constructors //
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Methods //
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
