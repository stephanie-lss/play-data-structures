package com.string.medium.solution890;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/4/13 10:58
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        pattern = hash(pattern);
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            } else {
                if (check(word, pattern)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

    public String hash(String str) {
        char idx = 'a';
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> mapper = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!mapper.containsKey(str.charAt(i))) {
                mapper.put(str.charAt(i), idx);
                sb.append(idx);
                idx++;
            } else {
                sb.append(mapper.get(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    private boolean check(String word, String pattern) {
        word = hash(word);
        return word.equals(pattern);
    }

    public static void main(String[] args) {
        String[] words = {"qxrwtncxyoqwmsxoavos", "eqvzjrnqgkezxmqkhdkm", "pjxmgdujohpmtsjhazhs", "yqhlipeqwnylkrqnsbnr", "plktdyslmoptqflowaof"};
        String pattern = "ghtxpauhingxekhnoqnk";
        System.out.println(new Solution().findAndReplacePattern(words, pattern));
    }
}
