package com.solution387;

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        if (s.isEmpty()){
            return -1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Solution().firstUniqChar("leetcode");
        System.out.println(i);
    }
}