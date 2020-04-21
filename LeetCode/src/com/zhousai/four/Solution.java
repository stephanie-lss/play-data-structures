package com.zhousai.four;

/**
 * @author LiSheng
 * @date 2020/4/18 16:59
 */
public class Solution {
    public int minJump(int[] jump) {
        if (jump == null || jump.length == 0) {
            return 0;
        }
        int maxCross = 0;
        int step = 0;
        int lastCross = 0;
        for (int i = 0; i <= maxCross && i < jump.length; i++) {
            if (i > lastCross) {
                ++step;
                lastCross = maxCross;
            }
            if (jump[i] + i > maxCross) {
                maxCross = jump[i] + i;
            }
        }
        if (jump.length - 2 >= maxCross) {
            return 0;
        }
        return step;
    }
}