import java.util.Comparator;

/**
 * @author LiSheng
 * @date 2020/1/4 21:51
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;
    private Comparator<E> comparator;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
