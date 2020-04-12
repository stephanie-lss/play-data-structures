package com.math.easy.solution868;

/**
 * @author LiSheng
 * @date 2020/4/10 17:36
 */
public class Solution {
    public int binaryGap(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int max = 0;
        int pre = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (pre != -1) {
                    max = Math.max(max, i - pre);
                }
                pre = i;
            }

        }
        return max;
    }
}
