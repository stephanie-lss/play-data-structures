package com.math.easy.solution69;

/**
 * @author LiSheng
 * @date 2020/5/9 11:33
 */
class Solution2 {
    public int mySqrt(int x) {
        long left = 0, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                } else {
                    left = mid + 1;
                }
            } else if (mid * mid > x) {
                if ((mid - 1) * (mid - 1) <= x) {
                    return (int) (mid - 1);
                } else {
                    right = mid - 1;
                }
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(new Solution2().mySqrt(x));
    }
}