package com.top100.solution128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/3 11:18
 */
class Solution3 {
    public class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> size;

        public UnionFind() {
            parent = new HashMap<>();
            size = new HashMap<>();
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (size.get(pRoot) < size.get(qRoot)) {
                parent.put(pRoot, qRoot);
                size.put(qRoot, size.get(pRoot) + size.get(qRoot));
            } else if (size.get(qRoot) < size.get(pRoot)) {
                parent.put(qRoot, pRoot);
                size.put(pRoot, size.get(pRoot) + size.get(qRoot));
            } else {
                parent.put(qRoot, pRoot);
                size.put(pRoot, size.get(pRoot) + size.get(qRoot));
            }
        }

        //返回节点p的根节点
        private int find(int p) {
            if (parent.get(p) != p) {
                p = find(parent.get(p));
            }
            return p;
        }
    }

    public int longestConsecutive(int[] nums) {
        UnionFind unionFind = new UnionFind();
        for (int num : nums) {
            unionFind.parent.put(num, num);
            unionFind.size.put(num, 1);
        }
        for (int num : nums) {
            if (unionFind.parent.containsKey(num + 1)) {
                unionFind.unionElements(num, num + 1);
            }
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, unionFind.size.get(num));
        }
        return res;
    }
}
