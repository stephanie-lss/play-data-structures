package com.offer.interview49;

/**
 * @author LiSheng
 * @date 2020/5/15 14:36
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int x2 = 0, x3 = 0, x5 = 0;
        for (int i = 1; i < n; i++) {
            num[i] = Math.min(Math.min(num[x2] * 2, num[x3] * 3), num[x5] * 5);
            if(num[i] == num[x2] * 2){
                x2++;
            }
            if(num[i] == num[x3] * 3){
                x3++;
            }
            if(num[i] == num[x5] * 5){
                x5++;
            }
        }
        return num[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(12));
    }
}