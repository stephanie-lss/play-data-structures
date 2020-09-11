package com.dp.linear.solution300;

/**
 * @author LiSheng
 * @date 2020/7/31 9:19
 */
public class Solution7 {
    public int lengthOfLIS(int[] nums) {
        int n = 0;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        int end = 0;
        int[] tail = new int[n];
        tail[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (tail[end] < nums[i]) {
                end++;
                tail[end] = nums[i];
            } else {
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] >= nums[i]) {
                        right = mid;
                    } else if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    }
                }
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(new Solution7().lengthOfLIS(nums));
    }
}
