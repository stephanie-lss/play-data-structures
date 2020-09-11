package com.array.easy.interview53_I;

/**
 * @author LiSheng
 * @date 2020/4/1 18:05
 */
public class Solution2 {
//    private static int res = 0;

    public int search(int[] nums, int target) {
        int targetIndex = binary(nums, 0, nums.length - 1, target);
        if (targetIndex == -1) {
            return 0;
        }
        int res = 1;
        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] == nums[targetIndex]) {
                res++;
            }
        }
//        for (int i = targetIndex - 1; i >= 0; i--) {
//            if (nums[i] == nums[targetIndex]) {
//                res++;
//            }
//        }
        return res;
    }

    private int binary(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = right - (right - left) / 2;
        if (nums[mid] > target) {
            return binary(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return binary(nums, mid + 1, right, target);
        } else {
            if (mid == 0) {
                //mid是最左边的
                return mid;
            } else {
                //mid在数组中间，并且左边还存在相同的数
                if (nums[mid - 1] == nums[mid]) {
                    return binary(nums, left, mid - 1, target);
                } else {
                    return mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        int targrt = 8;
        System.out.println(new Solution2().search(nums, targrt));
    }
}
