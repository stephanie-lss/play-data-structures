package com.array.easy.solution1010;

/**
 * @author LiSheng
 * @date 2020/3/28 15:03
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //用于记录与60-t互补的数的个数
        int[] record = new int[60];
        int count = 0;
        for (int t : time) {
            t = t % 60;
            if (t != 0) {
                count += record[60 - t];
            }else {
                count += record[0];
            }
            record[t]++;
        }
        return count;
    }
}
