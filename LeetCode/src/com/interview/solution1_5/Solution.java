package com.interview.solution1_5;

/**
 * @author LiSheng
 * @date 2020/6/23 14:44
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        if (Math.abs(len1 - len2) >= 2) {
            return false;
        }
        if (len1 > len2) {
            String tmp = first;
            first = second;
            second = tmp;
            int t = len1;
            len1 = len2;
            len2 = t;
        }
        int p1 = 0, p2 = 0, make = 1;
        while (p1 != len1) {
            if (first.charAt(p1) != second.charAt(p2)) {
                if (make-- == 0) {
                    return false;
                }
                //因为字符串长度相同，所以肯定是替换操作
                if (len1 < len2) {
                    p2++;
                } else {
                    p1++;
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String first = "";
        String second = "b";
        System.out.println(new Solution().oneEditAway(first, second));
    }
}
