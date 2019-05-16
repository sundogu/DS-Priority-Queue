package PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;

public class MyUnsortedPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {
    // Constructors //
    public MyUnsortedPriorityQueue() {
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
        queue.addFirst(entry);
        return true;
    }

    @Override
    public V removeMin() {
        Entry<K, V> temp = null;
        Iterator<Entry<K, V>> itr = queue.iterator();

        while (itr.hasNext()) {
            if (temp == null) {
                temp = itr.next();
            } else {
                Entry<K, V> entry = itr.next();
                if (comparator != null) {
                    temp = (comparator.compare(entry.getKey(), temp.getKey()) < 0)? entry : temp;
                } else {
                    temp = (entry.getKey().compareTo(temp.getKey()) < 0)? entry : temp;
                }
            }
        }

        if (temp != null) {
            queue.removeFirstOccurrence(temp);
        }

        return (temp == null)? null: temp.getValue();
    }

    @Override
    public V min() {
        Entry<K, V> temp = null;
        Iterator<Entry<K, V>> itr = queue.iterator();

        while (itr.hasNext()) {
            if (temp == null) {
                temp = itr.next();
            } else {
                Entry<K, V> entry = itr.next();
                if (comparator != null) {
                    temp = (comparator.compare(entry.getKey(), temp.getKey()) < 0)? entry : temp;
                } else {
                    temp = (entry.getKey().compareTo(temp.getKey()) < 0)? entry : temp;
                }
            }
        }

        return (temp == null)? null: temp.getValue();
    }
}
