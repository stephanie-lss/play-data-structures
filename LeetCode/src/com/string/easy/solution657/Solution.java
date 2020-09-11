package com.string.easy.solution657;

/**
 * @author LiSheng
 * @date 2020/4/4 12:50
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    ud++;
                    break;
                case 'D':
                    ud--;
                    break;
                case 'L':
                    lr++;
                    break;
                case 'R':
                    lr--;
                    break;
                default:
                    throw new IllegalArgumentException("Argument Error!");
            }
        }
        if (ud == 0 && lr == 0) {
            return true;
        } else {
            return false;
        }
    }
}
