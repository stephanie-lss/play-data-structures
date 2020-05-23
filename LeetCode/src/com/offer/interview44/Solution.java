package com.offer.interview44;

/**
 * @author LiSheng
 * @date 2020/5/23 13:13
 */
class Solution {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        //count保存位数
        int count = 0;
        //范围边界为[1~9]m=1 [10~99]m=2 [100~999]m=3 [1000~9999]m=4 ...
        int m = 1;
        //先找到对应的区间
        while (true) {
            //tmp为每一个区间内的数字的位数
            long tmp = (int) (m * 9 * Math.pow(10, m - 1));
            if (count + tmp > n) {
                return helper((int) (Math.pow(10, m - 1) - 1), count, m, n);
            } else {
                m++;
                count += tmp;
            }
        }
    }

    private int helper(int start, int count, int m, int n) {
        //n1为在这区间起始数值需要加上的大小
        int n1 = (n - count) / m;
        int n2 = (n - count) % m;
        int sum = start + n1;
        if (n2 == 0) {
            return sum % 10;
        } else {
            sum += 1;
            return String.valueOf(sum).charAt(n2 - 1) - '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(1000000000));
    }
}