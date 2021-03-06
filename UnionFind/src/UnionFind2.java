/**
 * @author LiSheng
 * @date 2020/1/6 10:32
 * version：2.0
 */
public class UnionFind2 implements UnionFind {
    //索引为当前节点的值，数组的值为当前节点指向的节点的值
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    //查看元素p和元素q是否所属一个集合
    //复杂度为O(h)，h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound. ");
        }
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
}
