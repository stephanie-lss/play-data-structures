/**
 * @author LiSheng
 * @date 2020/1/6 9:53
 */
public interface UnionFind {

    boolean isConnected(int p ,int q);

    void unionElements(int p,int q);

    int getSize();
}
