package com.interview.solution8_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/30 19:23
 */
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        while (!A.isEmpty()) {
            while (!C.isEmpty() && C.get(C.size() - 1) < A.get(0)) {
                B.add(C.remove(C.size() - 1));
            }
            while (!B.isEmpty() && B.get(B.size() - 1) > A.get(0)) {
                C.add(B.remove(B.size() - 1));
            }
            C.add(A.remove(0));
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(6);
        A.add(4);
        A.add(8);
        A.add(5);
        A.add(1);
        A.add(2);
        A.add(0);
        new Solution().hanota(A, B, C);
        for (Integer integer : C) {
            System.out.print(integer + " ");
        }
    }
}