package com.interview.solution5_3;

/**
 * @author LiSheng
 * @date 2020/6/28 10:01
 */
public class Solution {
    public int reverseBits(int num) {
        int res = 0, count = 0, preCount = 0;
        int change = 1;
        while (num != 0 || change != 0) {
            if (change == 1) {
                if ((num & 1) == 1) {
                    preCount++;
                } else {
                    change--;
                    preCount++;
                }
            } else {
                if ((num & 1) == 1) {
                    count++;
                } else {
                    res = Math.max(res, preCount + count);
                    preCount = count + 1;
                    count = 0;
                }
            }
            num >>>= 1;
        }
        return Math.max(res, count + preCount);
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(new Solution().reverseBits(num));
    }
}
