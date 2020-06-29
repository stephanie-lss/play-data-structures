package com.interview.solution5_6;

/**
 * @author LiSheng
 * @date 2020/6/28 13:39
 */
public class Solution {
    public int convertInteger(int A, int B) {
        A ^= B;
        B = 0;
        while (A != 0) {
            B += (A & 1);
            A >>>= 1;
        }
        return B;
    }
}
