package com.offer.interview48;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/21 9:14
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 1, max = 0;
        LinkedList<Character> queue = new LinkedList<>();
        char[] array = s.toCharArray();
        while (right <= s.length()) {
            if (!queue.contains(array[right - 1])) {
                queue.addLast(array[right - 1]);
                max = Math.max(max, queue.size());
                right++;
            } else {
                queue.removeFirst();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}