package com.offer.interview48;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/21 9:35
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> list = new LinkedList<>();
        //[lefr,right)，左闭右开区间
        int n = s.length(), left = 0, right = 0, max = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;
            if (list.contains(c)) {
                while (s.charAt(left) != c) {
                    list.removeFirst();
                    left++;
                }
                left++;
                list.removeFirst();
            }
            list.add(c);
            max = Math.max(max, list.size());
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(new Solution2().lengthOfLongestSubstring(str));
    }
}
