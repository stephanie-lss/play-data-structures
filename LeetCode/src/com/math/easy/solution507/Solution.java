package com.math.easy.solution507;

/**
 * @author LiSheng
 * @date 2020/4/8 16:56
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = num;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i != 1 && i * i != num){
                    sum -= (i + num / i);
                }else {
                    sum -= i;
                }
            }
        }
        return sum == 0;
    }
}
