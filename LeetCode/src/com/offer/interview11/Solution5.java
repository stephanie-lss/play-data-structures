package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/7/22 8:55
 */
public class Solution5 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] num = {1, 3, 3};
        System.out.println(new Solution5().minArray(num));
    }
}
