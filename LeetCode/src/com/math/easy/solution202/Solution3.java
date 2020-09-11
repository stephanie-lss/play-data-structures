package com.math.easy.solution202;

/**
 * @author LiSheng
 * @date 2020/4/30 9:28
 */
public class Solution3 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int squareSum(int n) {
        int res = 0;
        while (n != 0) {
            int y = n % 10;
            n /= 10;
            res += y * y;
        }
        return res;
    }
}
