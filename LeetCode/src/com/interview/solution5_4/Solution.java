package com.interview.solution5_4;

/**
 * @author LiSheng
 * @date 2020/6/28 11:14
 */
class Solution {
    public int[] findClosedNumbers(int num) {
        char[] small = ("0" + Integer.toBinaryString(num)).toCharArray();
        int smallCount = 0;
        boolean hasSmall = false;

        char[] big = ("0" + Integer.toBinaryString(num)).toCharArray();
        int bigCount = 0;
        boolean hasBig = false;

        for (int i = small.length - 1; i >= 1; i--) {
            if (!hasSmall) {
                if (small[i] == '0' && small[i - 1] == '1') {
                    hasSmall = true;
                    small[i] = '1';
                    small[i - 1] = '0';
                    for (int j = i + 1; j < i + 1 + smallCount; j++) {
                        small[j] = '1';
                    }
                    for (int j = i + 1 + smallCount; j < small.length; j++) {
                        small[j] = '0';
                    }
                } else if (small[i] == '1') {
                    smallCount++;
                }
            }

            if (!hasBig) {
                if (big[i] == '1' && big[i - 1] == '0') {
                    hasBig = true;
                    big[i] = '0';
                    big[i - 1] = '1';
                    for (int j = big.length - 1; j > big.length - 1 - bigCount; j--) {
                        big[j] = '1';
                    }
                    for (int j = big.length - 1 - bigCount; j >= i + 1; j--) {
                        big[j] = '0';
                    }
                } else if (big[i] == '1') {
                    bigCount++;
                }
            }
        }

        int max = 0, min = 0;
        int[] res = {-1, -1};
        if (hasBig && num != Integer.MAX_VALUE) {
            for (int i = 0; i < big.length; i++) {
                max = max * 2 + (big[i] - '0');
            }
            res[0] = max;
        }

        if (hasSmall) {
            for (int i = 0; i < small.length; i++) {
                min = min * 2 + (small[i] - '0');
            }
            res[1] = min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().findClosedNumbers(6);
        for (int re : res) {
            System.out.println(re);
        }
    }
}