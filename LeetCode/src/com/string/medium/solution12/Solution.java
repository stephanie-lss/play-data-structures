package com.string.medium.solution12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/13 13:35
 */
public class Solution {
    public String intToRoman(int num) {
        String[] first = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] second = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] third = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] fourth = {"M", "MM", "MMM"};
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            int i = num % 10;
            list.add(i);
            num /= 10;
        }
        switch (list.size()) {
            case 1:
                return first[list.get(0) - 1];
            case 2:
                if (list.get(0) != 0) {
                    return second[list.get(1) - 1] + first[list.get(0) - 1];
                } else {
                    return second[list.get(1) - 1];
                }
            case 3:
                String ret = third[list.get(2) - 1];
                if (list.get(1) != 0) {
                    ret += second[list.get(1) - 1];
                }
                if (list.get(0) != 0) {
                    ret += first[list.get(0) - 1];
                }
                return ret;
            default:
                ret = fourth[list.get(3) - 1];
                if (list.get(2) != 0) {
                    ret += third[list.get(2) - 1];
                }
                if (list.get(1) != 0) {
                    ret += second[list.get(1) - 1];
                }
                if (list.get(0) != 0) {
                    ret += first[list.get(0) - 1];
                }
                return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(20));
        System.out.println(new Solution().intToRoman(508));
        System.out.println(new Solution().intToRoman(1004));
    }
}
