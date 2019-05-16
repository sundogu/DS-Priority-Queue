package PriorityQueue;

import java.util.Comparator;
import java.util.ListIterator;

public class MySortedPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {
    // Constructors //
    public MySortedPriorityQueue() {
    }

    public MySortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    // Methods//
    @Override
    public boolean insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        Entry<K, V> entry = new Entry<>(key, value);
        ListIterator<Entry<K, V>> itr = queue.listIterator();

        while (itr.hasNext()) {
            Entry<K, V> temp = itr.next();
            if (comparator != null) {
                if (comparator.compare(temp.getKey(), key) < 0) {
                    break;
                }
            } else {
                if (temp.getKey().compareTo(key) < 0) {
                    break;
                }
            }
        }

        itr.add(entry);
        return true;
    }

    @Override
    public V removeMin() {
        return (queue.isEmpty())? null: queue.removeLast().getValue();
    }

    @Override
    public V min() {
        return (queue.isEmpty())? null : queue.getLast().getValue();
    }

    @Override
    public V removeMax() {
        return (queue.isEmpty())? null : queue.removeFirst().getValue();
    }

    @Override
    public V max() {
        return (queue.isEmpty())? null : queue.getFirst().getValue();
    }
}
