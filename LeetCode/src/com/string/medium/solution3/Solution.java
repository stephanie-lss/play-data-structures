package com.string.medium.solution3;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/2 9:45
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        int head = 0, tail = 0, max = 0;
        LinkedList<Character> linkedList = new LinkedList<>();
        while (head < len && tail < len) {
            if (!linkedList.contains(array[tail])) {
                linkedList.add(array[tail++]);
            } else {
                max = Math.max(max, linkedList.size());
                while (head < len) {
                    if (array[head] != array[tail]) {
                        head++;
                        linkedList.removeFirst();
                    } else {
                        linkedList.removeFirst();
                        linkedList.addLast(array[tail]);
                        head++;
                        tail++;
                        break;
                    }
                }
            }
        }
        return Math.max(tail - head, max);
    }

    public static void main(String[] args) {
        String str = "abcabcde";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}
