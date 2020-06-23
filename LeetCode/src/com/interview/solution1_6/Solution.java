package com.interview.solution1_6;

/**
 * @author LiSheng
 * @date 2020/6/23 15:24
 */
class Solution {
    public String compressString(String S) {
        int idx = 0, len = S.length();
        StringBuilder sb = new StringBuilder();
        while (idx != len) {
            char c = S.charAt(idx);
            int count = 1;
            while (idx + 1 < len && c == S.charAt(idx + 1)) {
                idx++;
                count++;
            }
            idx++;
            sb.append(c).append(count);
        }
        String press = sb.toString();
        return press.length() < len ? press : S;
    }

    public static void main(String[] args) {
        String S = "abbccd";
        System.out.println(new Solution().compressString(S));
    }
}