/**
 * @author LiSheng
 * @date 2020/1/6 10:57
 * version：3.0 添加路径压缩
 */
public class UnionFind5 implements UnionFind {
    //索引为当前节点的值，数组的值为当前节点指向的节点的值
    private int[] parent;
    //rank[i]表示以i为根的集合所表示的树的高度等级
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
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
            //路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
