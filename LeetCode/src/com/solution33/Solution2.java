package com.solution33;

/**
 * @author LiSheng
 * @date 2020/4/29 12:58
 */
class Solution2 {
    public int search(int[] nums, int target) {
        //寻找旋转点
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //等于号是为了防止当left = mid 的情况出现，因为数组中并不存在重复值，当出现等
            //于号的情况必然是left = mid的情况出现了并且由于nums[left]!=target，
            // 因此数组中并不存在目标值。由于区间是左闭右开的，此时的right = left + 1，
            //当left =mid出现后将进入此分支，left = mid + 1 = right，此时就可以退出循环
            if (nums[mid] >= nums[left]) {
                //mid左边有序
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                //mid右边有序
                if (target > nums[mid] && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 1;
        System.out.println(new Solution2().search(nums, target));
    }
}
