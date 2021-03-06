package com.interview.solution17_16;

/**
 * @author LiSheng
 * @date 2020/3/24 10:29
 */
public class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(nums[0] + service(nums, 2), nums[1] + service(nums, 3));
    }

    private int service(int[] nums, int index) {
        int res = 0;
        if (index >= nums.length) {
            return 0;
        }
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res,nums[i]+service(nums,i+2));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {2, 1, 4, 5, 3, 1, 1, 3};
        int[] nums4 = {0};
        System.out.println(new Solution().massage(nums));
        System.out.println(new Solution().massage(nums2));
        System.out.println(new Solution().massage(nums3));
        System.out.println(new Solution().massage(nums4));
    }
}
