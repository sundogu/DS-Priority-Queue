package PriorityQueue;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyHeapPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {
    // Class Variables //
    private List<Entry<K, V>> minHeap;

    // Constructors //
    public MyHeapPriorityQueue() {
        minHeap = new ArrayList<>();
    }

    public MyHeapPriorityQueue(Comparator<K> comparator) {
        super(comparator);
        minHeap = new ArrayList<>();
    }

    // Methods //
    @Override
    public int size() {
        return minHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    @Override
    public boolean insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        Entry<K, V> entry = new Entry<>(key, value);
        minHeap.add(entry);
        this.upHeap(minHeap.size() - 1);
        return true;
    }

    @Override
    public V removeMin() {
        V temp = this.min();
        if (temp != null) {
            this.swap(0, minHeap.size() - 1);
            this.downHeap(0);
        }

        return temp;
    }

    @Override
    public V min() {
        if (this.isEmpty()) {
            return null;
        } else {
            return minHeap.get(0).getValue();
        }
    }

    @Override
    public V removeMax() {
        throw new NotImplementedException();
    }

    @Override
    public V max() {
        throw new NotImplementedException();
    }


    // Helper Methods //
    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeft(int i) {
        return left(i) < minHeap.size();
    }

    private boolean hasRight(int i) {
        return right(i) < minHeap.size();
    }

    private void swap(int i, int j) {
        Entry<K, V> temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }

    private void upHeap(int i) {
        int temp = i;
        while (temp > 0) {
            int j = parent(temp);
            if (this.compare(minHeap.get(temp).getKey(), minHeap.get(j).getKey()) >= 0) {
                break;
            } else {
                swap(temp, j);
                temp = j;
            }
        }
    }

    private void downHeap(int i) {
        int temp = i;
        while (hasLeft(temp)) {
            int leftIdx = left(temp);
            int smallIdx = leftIdx;
            if (hasRight(temp)) {
                int rightIdx = right(temp);
                if (this.compare(minHeap.get(leftIdx).getKey(), minHeap.get(rightIdx).getKey()) > 0) {
                    smallIdx = rightIdx;
                }
            }

            if (this.compare(minHeap.get(smallIdx).getKey(), minHeap.get(temp).getKey()) >= 0) {
                break;
            }

            swap(temp, smallIdx);
            temp = smallIdx;
        }
    }
}
