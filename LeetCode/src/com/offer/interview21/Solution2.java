package com.offer.interview21;

/**
 * @author LiSheng
 * @date 2020/5/15 11:33
 */
public class Solution2 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        new Solution2().exchange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
