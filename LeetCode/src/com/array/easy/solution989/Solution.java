package com.array.easy.solution989;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/27 23:35
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; i--) {
            if (i >= 0) {
                K = K + A[i];
            }
            if (K >= 10) {
                res.addFirst(K % 10);
            } else {
                res.addFirst(K);
            }
            K /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4};
//        int K = 8766;
//        List<Integer> list = new Solution().addToArrayForm(A, K);
//        for (Integer i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        System.out.println();
//        int[] A1 = {2, 7, 4};
//        int K1 = 181;
//        List<Integer> list1 = new Solution().addToArrayForm(A1, K1);
//        for (Integer i : list1) {
//            System.out.print(i + " ");
//        }
        int[] A = {9};
        int K = 1;
        List<Integer> list = new Solution().addToArrayForm(A, K);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
