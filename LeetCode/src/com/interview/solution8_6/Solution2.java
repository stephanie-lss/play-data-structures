package com.interview.solution8_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/30 19:47
 */
public class Solution2 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        helper(A.size(), A, B, C);
    }

    private void helper(int n, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (n == 1) {
            c.add(a.remove(a.size() - 1));
            return;
        }
        helper(n - 1, a, c, b);
        c.add(a.remove(a.size() - 1));
        helper(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(6);
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(0);
        new Solution2().hanota(A, B, C);
        for (Integer integer : C) {
            System.out.print(integer + " ");
        }
    }
}
