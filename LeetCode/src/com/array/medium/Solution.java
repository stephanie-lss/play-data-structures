package com.array.medium;

/**
 * @author LiSheng
 * @date 2020/3/31 10:36
 */
public class Solution {
    //计数排序
    public int[] sortArray(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[0] > nums[j]) {
                    count++;
                }
            }
            int tmp = nums[count];
            nums[count] = nums[0];
            nums[0] = tmp;
            count = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={5,2,1,3};
        new Solution().sortArray(nums);
    }
//    冒泡排序
//    public int[] sortArray(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 1; j < nums.length - i; j++) {
//                if (nums[j - 1] > nums[j]) {
//                    int tmp = nums[j - 1];
//                    nums[j - 1] = nums[j];
//                    nums[j] = tmp;
//                }
//            }
//        }
//        return nums;
//    }
}
