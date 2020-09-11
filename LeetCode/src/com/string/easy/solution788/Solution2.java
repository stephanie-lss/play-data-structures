package com.string.easy.solution788;

/**
 * @author LiSheng
 * @date 2020/4/4 18:11
 */
public class Solution2 {
    public int rotatedDigits(int N) {
        int cur = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = check(i, false) ? 1 : 0;
            cur = cur + tmp;
        }
        return cur;
    }

    private boolean check(int n, boolean flag) {
        if (n == 0) {
            return flag;
        }
        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) {
            return false;
        }
        if (d == 0 || d == 1 || d == 8) {
            return check(n / 10, flag);
        }
        return check(n / 10, true);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().rotatedDigits(100));
    }
}
