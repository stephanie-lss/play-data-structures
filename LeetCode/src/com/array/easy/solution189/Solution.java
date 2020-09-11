package com.array.easy.solution189;

/**
 * @author LiSheng
 * @date 2020/3/28 19:58
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        while (k != 0) {
            //首先保存数组的最后一个数
            int tmp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
            k--;
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new Solution().rotate(nums, k);
    }
}
