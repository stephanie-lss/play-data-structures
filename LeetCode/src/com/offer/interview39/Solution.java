package com.offer.interview39;

/**
 * @author LiSheng
 * @date 2020/5/13 20:27
 */
class Solution {
    public int majorityElement(int[] nums) {
        int vote = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0 || res == nums[i]) {
                res = nums[i];
                vote++;
            }else {
                vote--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution().majorityElement(nums));
    }
}