package com.array.easy.solution189;

/**
 * @author LiSheng
 * @date 2020/3/28 19:58
 */
public class Solution2 {

    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int tmp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp;
        rotate(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new Solution2().rotate(nums, k);
    }
}
