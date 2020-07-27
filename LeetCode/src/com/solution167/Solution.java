package com.solution167;

/**
 * @author LiSheng
 * @date 2020/7/20 9:47
 */
public class Solution {
    private int[] res = new int[2];

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i])) {
                res[0] = i + 1;
                break;
            }
        }
        return res;
    }

    private boolean binarySearch(int[] numbers, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                res[1] = mid + 1;
                return true;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 9, 56, 90};
        int[] ints = new Solution().twoSum(nums, 8);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
