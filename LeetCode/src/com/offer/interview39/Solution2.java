package com.offer.interview39;

/**
 * @author LiSheng
 * @date 2020/5/13 20:27
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        int vote = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) res = nums[i];
            vote = (res == nums[i]) ? ++vote : --vote;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution2().majorityElement(nums));
    }
}