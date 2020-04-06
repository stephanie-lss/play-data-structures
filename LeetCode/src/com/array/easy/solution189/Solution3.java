package com.array.easy.solution189;

/**
 * @author LiSheng
 * @date 2020/3/28 19:58
 */
public class Solution3 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n);
        reverse(nums, 0, k);
        reverse(nums, k, n);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end - 1];
            nums[end - 1] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new Solution3().rotate(nums, k);
    }
}
