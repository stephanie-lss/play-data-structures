/**
 * @author LiSheng
 * @date 2020/1/5 13:32
 */
public interface Merger<E> {
    E merge(E a, E b);
}
