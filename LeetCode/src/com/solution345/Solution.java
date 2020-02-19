package com.solution345;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/18 10:27
 * 对撞指针
 */
public class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        List<Character> yList = new ArrayList<>();
        yList.add('a');
        yList.add('e');
        yList.add('i');
        yList.add('o');
        yList.add('u');
        yList.add('A');
        yList.add('E');
        yList.add('I');
        yList.add('O');
        yList.add('U');
        while (l < r) {
            while (!yList.contains(s.charAt(l)) && l < r) {
                l++;
            }
            while (!yList.contains(s.charAt(r)) && l < r) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                s = swap(s, l, r);
                l++;
                r--;
            } else {
                l++;
                r--;
            }
        }
        return s;
    }

    private String swap(String s, int l, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == l) {
                sb.append(s.charAt(r));
            } else if (i == r) {
                sb.append(s.charAt(l));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().reverseVowels(".,");
        System.out.println(s);
    }
}
