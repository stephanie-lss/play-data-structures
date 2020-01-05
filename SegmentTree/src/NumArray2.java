class NumArray2 {

    private interface Merger<E> {
        E merge(E a, E b);
    }
    /**
     * @author LiSheng
     * @date 2020/1/5 13:04
     */
    /**
     * @author LiSheng
     * @date 2020/1/5 13:04
     */
    public class SegmentTree<E> {

        private E[] tree;
        private E[] data;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];
            buildSegmrntTree(0, 0, data.length - 1);
        }

        /**
         * 在treeIndex的位置创建表示区间[l...r]的线段树
         *
         * @param treeIndex
         * @param l
         * @param r
         */
        private void buildSegmrntTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmrntTree(leftTreeIndex, l, mid);
            buildSegmrntTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }


        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return data[index];
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        //返回区间[queryL,queryR]的值
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal.");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        //在treeIndex为根的线段树中[l,r]的范围里，搜索区间[queryL,queryR]的值
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            if (queryL == l && queryR == r) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            if (queryR <= mid) {
                return query(leftChild(treeIndex), l, mid, queryL, queryR);
            } else if (queryL > mid) {
                return query(rightChild(treeIndex), mid + 1, r, queryL, queryR);
            } else {
                return merger.merge(query(leftChild(treeIndex), l, mid, queryL, mid), query(rightChild(treeIndex), mid + 1, r, mid + 1, queryR));
            }
        }

        //将index位置的值，更新为e
        public void set(int index, E e) {
            if (index < 0 || index > data.length-1) {
                throw new IllegalArgumentException("Index is illegal. ");
            }
            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        //在以treeIndex为根的线段树中更新index的值为e
        private void set(int treeIndex, int l, int r, int index, E e) {
            if (l == r && r == index) {
                tree[treeIndex] = e;
                return;
            }
            int mid = l + (r - l) / 2;
            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);
            if (index <= mid) {
                set(leftChildIndex, l, mid, index, e);
            } else {
                set(rightChildIndex, mid + 1, r, index, e);
            }

            tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("[");
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    res.append(tree[i]);
                } else {
                    res.append("null");
                }
                if (i != tree.length - 1) {
                    res.append(", ");
                } else {
                    res.append("]");
                }
            }
            return res.toString();
        }
    }


    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null.");
        }
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("Segment Tree is null. ");
        }
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 array = new NumArray2(nums);
        int res1 = array.sumRange(0, 2);
        int res2 = array.sumRange(2, 5);
        int res3 = array.sumRange(0, 5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */