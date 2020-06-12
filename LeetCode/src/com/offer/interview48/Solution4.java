package com.offer.interview48;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/12 15:41
 */
public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, len = s.length(), max = 0;
        Queue<Character> queue = new LinkedList<>();
        while (right < len) {
            max = Math.max(max, queue.size());
            char c = s.charAt(right);
            if (queue.contains(c)) {
                while (queue.peek() != c) {
                    queue.poll();
                }
                queue.poll();
            }
            queue.offer(c);
            right++;
        }
        return Math.max(max, queue.size());
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        String str1 = "bbbbb";
        String str2 = "pwwkew";
        String str3 = " ";
        System.out.println(new Solution4().lengthOfLongestSubstring(str));
        System.out.println(new Solution4().lengthOfLongestSubstring(str1));
        System.out.println(new Solution4().lengthOfLongestSubstring(str2));
        System.out.println(new Solution4().lengthOfLongestSubstring(str3));
    }
}
