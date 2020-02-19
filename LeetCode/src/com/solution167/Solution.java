package com.solution167;

/**
 * @author LiSheng
 * @date 2020/2/18 10:01
 * 对撞指针
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] res = new int[2];
        if (numbers[i] + numbers[j] == target) {
            res[0] = i + 1;
            res[1] = j + 1;
            return res;
        }
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
            res[0] = i + 1;
            res[1] = j + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 25, 75};
        int[] ints = new Solution().twoSum(nums, 100);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
