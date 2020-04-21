package com.string.medium.solution1023;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/18 14:44
 */
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        int len = pattern.length();
        for (String query : queries) {
            boolean flag = true;
            int cur = 0;
            for (int i = 0; i < query.length(); i++) {
                System.out.println(i);
                if (cur < len && pattern.charAt(cur) == query.charAt(i)) {
                    cur++;
                } else if (Character.isUpperCase(query.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            res.add(flag && cur == len);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pat = "FoBa";
        System.out.println(new Solution().camelMatch(queries, pat));
    }
}