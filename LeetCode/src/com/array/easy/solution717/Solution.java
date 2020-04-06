package com.array.easy.solution717;

/**
 * @author LiSheng
 * @date 2020/3/30 14:18
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) {
            return true;
        }
        for (int i = 0; ; ) {
            if (bits[i] == 1) {
                i += 2;
                if (i == bits.length) {
                    return false;
                }
            } else {
                i++;
            }
            if (i == bits.length - 1) {
                return true;
            }
        }
    }
}
