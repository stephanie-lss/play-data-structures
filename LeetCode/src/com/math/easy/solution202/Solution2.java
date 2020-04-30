package com.math.easy.solution202;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/30 9:10
 */
public class Solution2 {
    public boolean isHappy(int n) {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        while (sum != 1) {
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
            sum = 0;
            while (n != 0) {
                int y = n % 10;
                n /= 10;
                sum += y * y;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isHappy(19));
    }
}
