package com.string.easy.solution824;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/4 22:10
 */
public class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String[] strings = S.split("\\s");
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (set.contains(strings[i].charAt(0))) {
                word.append(strings[i]).append("ma");
            } else {
                word.append(strings[i].subSequence(1, strings[i].length())).append(strings[i].subSequence(0, 1)).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                word.append("a");
            }
            word.append(" ");
        }
        return word.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
