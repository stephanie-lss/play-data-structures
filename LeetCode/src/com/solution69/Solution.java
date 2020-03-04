package com.solution69;

/**
 * @author LiSheng
 * @date 2020/2/23 13:29
 */
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int l = 1;
        int r = x / 2;
        return (int) binSearch(l, r, x);
    }

    private long binSearch(long l, long r, int x) {
        long m = r - (r - l) / 2;
        if (m * m == x) {
            return m;
        } else if (m * m < x) {
            if ((m + 1) * (m + 1) > x) {
                return m;
            } else {
                return binSearch(m + 1, r, x);
            }
        } else {
            if ((m - 1) * (m - 1) < x) {
                return m - 1;
            } else {
                return binSearch(l, m - 1, x);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}
