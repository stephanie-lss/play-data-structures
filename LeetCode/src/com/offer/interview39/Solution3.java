package com.offer.interview39;

/**
 * @author LiSheng
 * @date 2020/6/8 9:39
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        int vote = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res != nums[i]) {
                if (vote != 0) {
                    vote--;
                } else {
                    vote = 1;
                    res = nums[i];
                }
            } else {
                vote++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Solution3().majorityElement(nums));
    }
}
