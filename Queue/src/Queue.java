/**
 * @author LiSheng
 * @date 2019/12/30 18:25
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
