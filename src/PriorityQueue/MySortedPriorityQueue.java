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
        ListIterator<Entry<K, V>> itr = this.getQueue().listIterator();

        while (itr.hasNext()) {
            Entry<K, V> temp = itr.next();
            if (this.getComparator() != null) {
                if (this.getComparator().compare(temp.getKey(), key) < 0) {
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
        return (this.getQueue().isEmpty())? null: this.getQueue().removeLast().getValue();
    }

    @Override
    public V min() {
        return (this.getQueue().isEmpty())? null : this.getQueue().getLast().getValue();
    }

    @Override
    public V removeMax() {
        return (this.getQueue().isEmpty())? null : this.getQueue().removeFirst().getValue();
    }

    @Override
    public V max() {
        return (this.getQueue().isEmpty())? null : this.getQueue().getFirst().getValue();
    }
}
