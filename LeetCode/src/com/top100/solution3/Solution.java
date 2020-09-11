package com.top100.solution3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/8/3 10:38
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = 0;
        if (s == null || (n = s.length()) == 0) {
            return 0;
        }
        int res = 0, right = 0;
        Queue<Character> queue = new LinkedList<>();
        while (right < n) {
            char c = s.charAt(right);
            right++;
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}
