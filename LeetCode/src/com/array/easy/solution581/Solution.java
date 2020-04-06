package com.array.easy.solution581;

/**
 * @author LiSheng
 * @date 2020/3/29 20:10
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
        int head = 0;
        int tail = nums.length - 1;
        boolean flag1 = false;
        boolean flag2 = false;

        while (head < tail & (!flag1 || !flag2)) {
            if (!flag1) {
                int min = findMin(nums, head + 1, tail);
                if (nums[head] <= min) {
                    head++;
                } else {
                    flag1 = true;
                }
            }
            if (!flag2) {
                int max = findMax(nums, head, tail);
                if (nums[tail] >= max) {
                    tail--;
                } else {
                    flag2 = true;
                }
            }
        }
        if (tail == head) {
            return 0;
        }
        return tail - head + 1;
    }

    private int findMin(int[] nums, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
