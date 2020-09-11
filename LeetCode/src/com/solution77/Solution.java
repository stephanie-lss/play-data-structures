package com.solution77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/27 10:46
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        operate(n, k, list, 1);
        return res;
    }

    private void operate(int n, int k, LinkedList<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            operate(n, k, list, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution().combine(4, 2);
    }
}
