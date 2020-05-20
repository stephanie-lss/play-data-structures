package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/5/20 11:21
 */
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[left]) {
                //mid左边是递增的
                //此时有两种情况
                if (numbers[mid] <= numbers[right - 1]) {
                    //此时最小值在左边
                    return numbers[left];
                } else if (numbers[mid] > numbers[right - 1]) {
                    //此时最小值在右边
                    left = mid + 1;
                }
            } else if (numbers[mid] < numbers[left]) {
                //mid右边是递增的
                //存在两种情况
                if (numbers[mid] < numbers[mid - 1]) {
                    return numbers[mid];
                } else {
                    right = mid;
                }
            } else {
                if (numbers[mid] > numbers[right - 1]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[right - 1]) {
                    return numbers[left];
                } else {
                    left++;
                }
            }
        }
        return numbers[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(new Solution().minArray(nums));
    }
}