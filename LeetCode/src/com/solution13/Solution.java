package com.solution13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/2/22 16:45
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> maper = new HashMap<>();
        maper.put('I', 1);
        maper.put('V', 5);
        maper.put('X', 10);
        maper.put('L', 50);
        maper.put('C', 100);
        maper.put('D', 500);
        maper.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i + 1) < s.length()&&maper.get(s.charAt(i)) < maper.get(s.charAt(i + 1))) {
                // MCMXCIV
                res += maper.get(s.charAt(i + 1)) - maper.get(s.charAt(i));
                i++;
            } else {
                //III
                res += maper.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("IIII"));
    }
}
