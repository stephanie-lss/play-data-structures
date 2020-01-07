package com.solution387;

import java.util.ArrayList;
import java.util.HashMap;

class Solution2 {
    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c) && !list.contains(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.remove(c);
                list.add(c);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Solution2().firstUniqChar("lleettccooddoe");
        System.out.println(i);
    }
}