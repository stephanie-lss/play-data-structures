package com.solution387;

class Solution3 {
    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Solution3().firstUniqChar("loveleetcode");
        System.out.println(i);
    }
}