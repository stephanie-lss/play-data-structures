package com.interview.solution5_2;

/**
 * @author LiSheng
 * @date 2020/6/28 9:43
 */
class Solution {
    public String printBin(double num) {
        StringBuilder res = new StringBuilder("0.");
        int count = 30;
        while (num != 0 && (count--) > 0) {
            num *= 2;
            if (num >= 1) {
                res.append(1);
                --num;
            } else {
                res.append(0);
            }
        }
        return Math.abs(num) < Double.MIN_VALUE ? res.toString() : "ERROR";
    }
}