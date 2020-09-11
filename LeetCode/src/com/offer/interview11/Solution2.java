package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/5/20 15:12
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        return findMin(numbers, 0, numbers.length - 1);
    }

    private int findMin(int[] numbers, int left, int right) {
        if (left == right) {
            return numbers[left];
        }
        int mid = left + (right - left) / 2;
        if (numbers[mid] > numbers[left]) {
            if (numbers[mid] <= numbers[right]) {
                return numbers[left];
            } else {
                return findMin(numbers, mid + 1, right);
            }
        } else if (numbers[mid] < numbers[left]) {
            return findMin(numbers, left, mid);
        } else {
            if (numbers[mid] > numbers[right]) {
                return findMin(numbers, mid + 1, right);
            } else if (numbers[mid] < numbers[right]) {
                return numbers[left];
            } else {
                return findMin(numbers,++left,right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 10, 10, 10};
        System.out.println(new Solution2().minArray(nums));
    }
}
