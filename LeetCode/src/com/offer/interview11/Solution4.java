package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/7/4 13:28
 */
public class Solution4 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[left] > numbers[right]) {
                if (numbers[mid] >= numbers[left]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[left]) {
                    right = mid;
                }
            } else if (numbers[left] == numbers[right]) {
                left++;
            } else if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
        }
        return numbers[left];
    }
}
