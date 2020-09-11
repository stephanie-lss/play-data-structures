package com.offer.interview59_I;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/21 17:11
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if (i > 0 && nums[i - 1] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }

            deque.offer(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] res = new Solution2().maxSlidingWindow(nums, 3);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
