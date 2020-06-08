package com.top100.solution128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/6 9:47
 */
public class Solution6 {
    private class UnionFind {
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> size;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.size = new HashMap<>();
        }

        public void unionElement(int num1, int num2) {
            int num1Root = findRoot(num1);
            int num2Root = findRoot(num2);
            if (num1Root == num2Root) {
                return;
            }
            if (size.get(num1Root) < size.get(num2Root)) {
                parent.put(num1Root, num2Root);
                size.put(num2Root, size.get(num1Root) + size.get(num2Root));
            } else {
                parent.put(num2Root, num1Root);
                size.put(num1Root, size.get(num1Root) + size.get(num2Root));
            }
        }
        private int findRoot(int num) {
            int p = parent.get(num);
            if (num != p) {
                return findRoot(p);
            } else {
                return p;
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        int max = 0;
        UnionFind unionFind = new UnionFind();
        for (int num : nums) {
            unionFind.parent.put(num, num);
            unionFind.size.put(num, 1);
        }
        for (int num : nums) {
            if (unionFind.parent.containsKey(num + 1)) {
                unionFind.unionElement(num, num + 1);
            }
        }
        for (int num : nums) {
            max = Math.max(max, unionFind.size.get(num));
        }
        return max;
    }
}
