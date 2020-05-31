package com.offer.interview11;

/**
 * @author LiSheng
 * @date 2020/5/31 13:57
 */
class Solution3 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums3 = {10, 1, 10, 10, 10};
        System.out.println(new Solution3().minArray(nums3));
    }
}