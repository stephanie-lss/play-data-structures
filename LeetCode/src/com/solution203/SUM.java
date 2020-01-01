package com.solution203;

/**
 * @author LiSheng
 * @date 2019/12/31 10:10
 */
public class SUM {

    public static int sum(int[] nums) {
        return sum(nums, 0);
    }

    /**
     * 递归函数，求数组中索引（l-（nums.length））和
     *
     * @param nums
     * @param l
     * @return
     */
    private static int sum(int[] nums, int l) {
        if (l == nums.length) {
            return 0;
        }
        return nums[l] + sum(nums, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sum(nums, 0));
    }
}
