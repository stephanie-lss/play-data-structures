/**
 * @author LiSheng
 * @date 2020/1/4 14:25
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
