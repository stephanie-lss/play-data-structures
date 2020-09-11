package com.math.easy.solution263;

/**
 * @author LiSheng
 * @date 2020/4/8 15:10
 */
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        while (true) {
            boolean isUgly = false;
            if (num % 2 == 0) {
                num /= 2;
                isUgly = true;
            } else if (num % 3 == 0) {
                num /= 3;
                isUgly = true;
            } else if (num % 5 == 0) {
                num /= 5;
                isUgly = true;
            }
            if (!isUgly) {
                break;
            }
        }
        return num == 1 || num == -1;
    }
}
