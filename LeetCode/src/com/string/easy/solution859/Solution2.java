package com.string.easy.solution859;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/4 22:35
 */
public class Solution2 {
    public boolean buddyStrings(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 1) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> setA = new HashSet<>();
            for (char c : charsA) {
                setA.add(c);
            }
            if (setA.size() < A.length()) {
                return true;
            }
        }
        int[] index = new int[2];
        Arrays.fill(index, -1);
        int idx = 0;
        for (int i = 0; i < charsA.length; i++) {
            char a = charsA[i];
            char b = charsB[i];
            if (a != b) {
                if (idx == 2) {
                    return false;
                }
                index[idx++] = i;
            }
        }
        if (index[0] == -1 || index[1] == -1) {
            return false;
        }
        char tmp = charsA[index[0]];
        charsA[index[0]] = charsA[index[1]];
        charsA[index[1]] = tmp;
        return String.valueOf(charsA).equals(B);
    }

    public static void main(String[] args) {
        String A = "";
        String B = "";
        System.out.println(new Solution2().buddyStrings(A, B));
    }
}
