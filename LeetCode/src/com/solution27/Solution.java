package com.solution27;

/**
 * @author LiSheng
 * @date 2020/2/17 11:23
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
                count++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = new Solution().removeElement(nums, 2);
        System.out.println(i);
    }
}