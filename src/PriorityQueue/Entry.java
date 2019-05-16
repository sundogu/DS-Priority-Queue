package PriorityQueue;

public class Entry<K, V> {
    // Class Variables //
    private K key;
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
