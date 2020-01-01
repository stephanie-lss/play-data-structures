/**
 * @author LiSheng
 * @date 2019/12/30 15:49
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
