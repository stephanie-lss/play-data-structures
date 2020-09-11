package com.array.easy.solution1160;

/**
 * @author LiSheng
 * @date 2020/3/30 22:42
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder(chars);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = sb.indexOf(c + "");
                if (index < 0) {
                    break;
                } else {
                    sb.delete(index, index + 1);
                    if (i == word.length() - 1) {
                        res += word.length();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(new Solution().countCharacters(words, chars));
    }
}
