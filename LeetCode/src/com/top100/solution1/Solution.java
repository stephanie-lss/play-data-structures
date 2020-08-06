package com.top100.solution1;


import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/8/3 9:59
 */
public class Solution {
    private int[] res = new int[2];
    private int[] indexs;

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        this.res = new int[2];
        this.indexs = new int[n];
        for (int i = 0; i < n; i++) {
            indexs[i] = i;
        }
        sort(nums);
        for (int i = 0; i < n; i++) {
            res[0] = indexs[i];
            if (binarySearch(nums, i + 1, n - 1, target - nums[indexs[i]])) {
                return res;
            }
        }
        return res;
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[indexs[j]] > nums[indexs[j + 1]]) {
                    int tmp = indexs[j];
                    indexs[j] = indexs[j + 1];
                    indexs[j + 1] = tmp;
                }
            }
        }
    }

    private boolean binarySearch(int[] nums, int left, int right, int t) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[indexs[mid]] == t) {
                res[1] = indexs[mid];
                return true;
            } else if (nums[indexs[mid]] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int[] ints = new Solution().twoSum(nums, 0);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
