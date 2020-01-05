/**
 * @author LiSheng
 * @date 2020/1/5 12:23
 */
public class ArrayPriorityQueue<E> implements Queue<E> {
    private Array<E> array;
    private int size;

    public ArrayPriorityQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayPriorityQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
