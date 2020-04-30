package com.interview.solution51;

/**
 * @author LiSheng
 * @date 2020/4/24 9:52
 */
public class Solution3 {
    public int reversePairs(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = helper(nums, left, mid);
        int rightCount = helper(nums, mid + 1, right);
        if (nums[mid] < nums[mid + 1]) {
            return leftCount + rightCount;
        }
        int mergeCount = merge(nums, left, mid, right);
        return leftCount + rightCount + mergeCount;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int l = left;
        int r = mid + 1;
        int[] arr = new int[right - left + 1];
        int idx = 0;

        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                arr[idx++] = nums[l++];
            } else if (nums[l] > nums[r]) {
                arr[idx++] = nums[r++];
                count += mid - l + 1;
            }
        }
        while (l <= mid) {
            arr[idx++] = nums[l++];
        }

        while (r <= right) {
            arr[idx++] = nums[r++];
        }

        for (int i = 0; i < arr.length; i++) {
            nums[left + i] = arr[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3998, 2586, 5437, 589, 1390, 4131, 2243, 837, 5507, 1167, 2084, 457, 2943, 261, 2616, 1787, 776, 986, 5161};
        System.out.println(new Solution3().reversePairs(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
