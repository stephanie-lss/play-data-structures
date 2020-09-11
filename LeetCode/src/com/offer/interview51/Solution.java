package com.offer.interview51;

/**
 * @author LiSheng
 * @date 2020/6/13 10:24
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        int left = mergeSort(nums, l, m);
        int right = mergeSort(nums, m + 1, r);
        return left + right + merge(nums, l, m, r);
    }

    private int merge(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int idx = 0;
        int count = 0;
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (nums[left] <= nums[right]) {
                tmp[idx++] = nums[left++];
            } else if (nums[left] > nums[right]) {
                tmp[idx++] = nums[right++];
                count += m - left + 1;
            }
        }
        while (left <= m) {
            tmp[idx++] = nums[left++];
        }
        while (right <= r) {
            tmp[idx++] = nums[right++];
        }
        if (r + 1 - l >= 0) {
            System.arraycopy(tmp, 0, nums, l, r + 1 - l);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println(new Solution().reversePairs(arr));
    }
}