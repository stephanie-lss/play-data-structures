package com.offer.interview57;

/**
 * @author LiSheng
 * @date 2020/6/16 9:44
 */
public class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            } else if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            }
        }
        return res;
    }
}
