package PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;

public class MyUnsortedPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {
    // Class Variables //
    private Entry<K, V> minEntry;
    private Entry<K, V> maxEntry;
    // Constructors //
    public MyUnsortedPriorityQueue() {
        super();
    }

    public MyUnsortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    // Methods//
    @Override
    public boolean insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        Entry<K, V> entry = new Entry<>(key, value);
        this.getQueue().addLast(entry);

        if (minEntry == null) {
            minEntry = entry;
            maxEntry = entry;
        } else {
            if (this.getComparator() != null) {
                minEntry = (this.getComparator().compare(entry.getKey(), minEntry.getKey()) < 0)? entry : minEntry;
                maxEntry = (this.getComparator().compare(entry.getKey(), minEntry.getKey()) > 0)? entry : maxEntry;
            } else {
                minEntry = (entry.getKey().compareTo(minEntry.getKey()) < 0)? entry : minEntry;
                maxEntry = (entry.getKey().compareTo(maxEntry.getKey()) > 0)? entry : maxEntry;
            }
        }

        return true;
    }

    @Override
    public V removeMin() {
        if (minEntry != null) {
            this.getQueue().removeFirstOccurrence(minEntry);
        }

        Entry<K, V> tempMin = minEntry;
        minEntry = null;
        Iterator<Entry<K, V>> itr = this.getQueue().iterator();

        while (itr.hasNext()) {
            if (minEntry == null) {
                minEntry = itr.next();
            } else {
                Entry<K, V> entry = itr.next();
                if (this.getComparator() != null) {
                    minEntry = (this.getComparator().compare(entry.getKey(),minEntry.getKey()) < 0)? entry : minEntry;
                } else {
                    minEntry = (entry.getKey().compareTo(minEntry.getKey()) < 0)? entry : minEntry;
                }
            }
        }

        return (tempMin == null)? null: tempMin.getValue();
    }

    @Override
    public V min() {
        return (minEntry == null)? null: minEntry.getValue();
    }

    @Override
    public V removeMax() {
        if (maxEntry != null) {
            this.getQueue().removeFirstOccurrence(maxEntry);
        }

        Entry<K, V> tempMax = maxEntry;
        maxEntry = null;
        Iterator<Entry<K, V>> itr = this.getQueue().iterator();

        while (itr.hasNext()) {
            if (maxEntry == null) {
                maxEntry = itr.next();
            } else {
                Entry<K, V> entry = itr.next();
                if (this.getComparator() != null) {
                    maxEntry = (this.getComparator().compare(entry.getKey(),maxEntry.getKey()) > 0)? entry : maxEntry;
                } else {
                    maxEntry = (entry.getKey().compareTo(maxEntry.getKey()) > 0)? entry : maxEntry;
                }
            }
        }

        return (tempMax == null)? null: tempMax.getValue();
    }

    @Override
    public V max() {
        return (maxEntry == null)? null: maxEntry.getValue();
    }
}
