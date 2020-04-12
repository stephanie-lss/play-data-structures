package com.math.easy.solution633;

/**
 * @author LiSheng
 * @date 2020/4/8 18:59
 */
public class Solution3 {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            int b = c - (int)(i * i);
            if (binary(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean binary(long l, long r, int b) {
        if (l > r) {
            return false;
        }
        long m = r - (r - l) / 2;
        if (m * m == b) {
            return true;
        } else if (b - m * m > 0) {
            return binary(m + 1, r, b);
        } else {
            return binary(l, m - 1, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().judgeSquareSum(1000000000));
    }
}
