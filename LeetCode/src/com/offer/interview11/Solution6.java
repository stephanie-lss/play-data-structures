package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/7/30 9:15
 */
public class Solution6 {
    public int minArray(int[] numbers) {
        int n = 0;
        if (numbers == null || (n = numbers.length) == 0) {
            return -1;
        }

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            }
        }
        return numbers[left];
    }
}
