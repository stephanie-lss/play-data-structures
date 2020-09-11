package com.math.easy.solution202;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/19 12:44
 */
public class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        String s = String.valueOf(n);
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            int l = s.length();
            for (int i = 0; i < l; i++) {
                sum += Integer.valueOf(s.charAt(i) - 48) * Integer.valueOf(s.charAt(i) - 48);
            }
            if (list.contains(sum)){
                return false;
            }else {
                list.add(sum);
            }
            s = String.valueOf(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Solution().isHappy(2);
        System.out.println(flag);
    }
}
