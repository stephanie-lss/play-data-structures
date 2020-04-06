package com.string.easy.solution859;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/4 22:35
 */
public class Solution {
    public boolean buddyStrings(String A, String B) {
        Map<Character, Integer> recordA = new LinkedHashMap<>();
        Map<Character, Integer> recordB = new LinkedHashMap<>();
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            Set<Character> setA = new HashSet<>();
            Set<Character> setB = new HashSet<>();
            char[] chars = A.toCharArray();
            for (char c : chars) {
                setA.add(c);
            }
            chars = B.toCharArray();
            for (char c : chars) {
                setB.add(c);
            }
            if (setA.size() == 1 && setB.size() == 1) {
                return true;
            }
            if (A.length() >= 3 && setA.size() < A.length()) {
                return true;
            }
        }

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a != b) {
                if (recordA.size() == 2 || recordB.size() == 2) {
                    return false;
                }
                recordA.put(a, i);
                recordB.put(b, i);
            }
        }
        if (recordA.size() != 2 || recordB.size() != 2) {
            return false;
        }
        char[] aKeys = new char[2];
        char[] bKeys = new char[2];
        int idx = 0;
        Iterator<Character> iteratorA = recordA.keySet().iterator();
        Iterator<Character> iteratorB = recordB.keySet().iterator();
        while (iteratorA.hasNext()) {
            aKeys[idx++] = iteratorA.next();
        }
        idx = 0;
        while (iteratorB.hasNext()) {
            bKeys[idx++] = iteratorB.next();
        }
        if (aKeys[0] == bKeys[1] && aKeys[1] == bKeys[0] && recordA.get(aKeys[0]).equals(recordB.get(bKeys[0])) && recordA.get(aKeys[1]).equals(recordB.get(bKeys[1]))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String A = "abcaa";
        String B = "abcbb";
        System.out.println(new Solution().buddyStrings(A, B));
    }
}
