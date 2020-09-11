package com.array.easy.solution896;

/**
 * @author LiSheng
 * @date 2020/3/30 21:55
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1 || A.length == 2) {
            return true;
        }
        boolean flag = false;
        int j = 0;
        for (j = 0; j < A.length - 1; j++) {
            if (A[j + 1] > A[j]) {
                flag = true;
                break;
            } else if (A[j + 1] < A[j]) {
                break;
            }
        }
        for (int i = j; i < A.length - 1; i++) {
            if (flag) {
                //判断是否为递增
                if (A[i + 1] < A[i]) {
                    return false;
                }
            } else {
                //判断是否为递减
                if (A[i + 1] > A[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution().isMonotonic(nums));
    }
}