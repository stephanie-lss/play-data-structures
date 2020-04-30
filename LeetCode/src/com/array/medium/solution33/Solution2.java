package com.array.medium.solution33;

/**
 * @author LiSheng
 * @date 2020/4/27 9:12
 */
class Solution2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                //前部半分有序
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 4;
        int target2 = 5;
        int target3 = 6;
        int target4 = 7;
        int target5 = 0;
        int target6 = 1;
        int target7 = 2;
        int target8 = 3;
        int target9 = 8;
        int target10 = 11;
        int target11 = -1;
        System.out.println(new Solution2().search(nums, target1));
        System.out.println(new Solution2().search(nums, target2));
        System.out.println(new Solution2().search(nums, target3));
        System.out.println(new Solution2().search(nums, target4));
        System.out.println(new Solution2().search(nums, target4));
        System.out.println(new Solution2().search(nums, target5));
        System.out.println(new Solution2().search(nums, target6));
        System.out.println(new Solution2().search(nums, target7));
        System.out.println(new Solution2().search(nums, target8));
        System.out.println(new Solution2().search(nums, target9));
        System.out.println(new Solution2().search(nums, target10));
        System.out.println(new Solution2().search(nums, target11));
        System.out.println("**");
        int[] nums2 = {5,1,3};
        int t1 = 1;
        int t2 = 3;
        int t3 = 5;
        int t4 = 0;
        int t5 = 2;
        int t6 = 4;
        int t7 = 6;
        System.out.println(new Solution2().search(nums2, t1));
        System.out.println(new Solution2().search(nums2, t2));
        System.out.println(new Solution2().search(nums2, t3));
        System.out.println(new Solution2().search(nums2, t4));
        System.out.println(new Solution2().search(nums2, t5));
        System.out.println(new Solution2().search(nums2, t6));
        System.out.println(new Solution2().search(nums2, t7));
    }
}