package com.offer.interview21;

/**
 * @author LiSheng
 * @date 2020/5/15 10:38
 */
class Solution {
    public int[] exchange(int[] nums) {
        mergeHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeHelper(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeHelper(nums, left, mid);
            mergeHelper(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low, right = mid + 1, idx = 0;
        int startL = -1;
        while (left <= mid) {
            if ((nums[left] & 1) == 0) {
                startL = left;
                break;
            } else {
                left++;
            }
        }
        int startR = high;
        for (int i = right; i <= high; i++) {
            if ((nums[i] & 1) == 0) {
                startR = i - 1;
                break;
            }
        }
        if (startL == -1) {
            return;
        }
        while (startL <= mid && startR > mid) {
            swap(nums, startL++, startR--);
        }
//        System.out.println("***");
//        for (int i = low; i <= high; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,4};
        new Solution().exchange(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}