package com.offer.interview40;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/5/15 21:51
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() > arr[i]) {
                    pq.remove();
                } else {
                    continue;
                }
            }
            pq.add(arr[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(new Solution().getLeastNumbers(arr, 2));
    }
}