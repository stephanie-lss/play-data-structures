package com.top100.solution139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/5 20:49
 */
class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            int i = s.indexOf(s1);
            System.out.println(i);
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wo = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String str = "catsandog";
        System.out.println(new Solution3().wordBreak(str, wo));
    }
}
