package com.offer.interview59_I;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/17 15:04
 */
public class Solution4 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.poll();
            }
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        int idx = 1;
        for (int i = k; i < n; i++) {
            if (queue.peek() == nums[i - k]) {
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peek() < nums[i]) {
                queue.poll();
            }
            queue.add(nums[i]);
            res[idx++] = queue.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 4};
        int[] ints = new Solution4().maxSlidingWindow(nums, 1);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
