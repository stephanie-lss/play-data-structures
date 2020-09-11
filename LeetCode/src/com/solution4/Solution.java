package com.solution4;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/5/24 13:46
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int total = nums1.length + nums2.length;

        for (int i = 0; i < nums1.length; i++) {
            maxPQ.offer(nums1[i]);
            if (maxPQ.size() > total / 2) {
                minPQ.offer(maxPQ.poll());
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            maxPQ.offer(nums2[i]);
            if (maxPQ.size() > total / 2) {
                minPQ.offer(maxPQ.poll());
            }
        }

        if ((total & 1) == 1) {
            return minPQ.peek();
        } else {
            return (maxPQ.peek() + minPQ.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}