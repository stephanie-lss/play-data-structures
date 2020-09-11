package com.top100.solution239;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/5/3 17:05
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        res[idx++] = pq.peek();
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.offer(nums[i]);
            res[idx++] = pq.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(new Solution().maxSlidingWindow(nums, k));
    }
}