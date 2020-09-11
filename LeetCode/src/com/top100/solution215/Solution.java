package com.top100.solution215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/4/28 19:12
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else {
                if (pq.peek() < num && !pq.contains(num)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();
    }
}
