package com.array.easy.solution830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 16:21
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (i != 0 && c != S.charAt(i - 1)) {
                count = 0;
            }
            count++;
            if ((i == S.length() - 1 || S.charAt(i + 1) != S.charAt(i)) && count >= 3) {
                res.add(Arrays.asList(new Integer[]{i - count + 1, i}));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().largeGroupPositions("abcdddeeeeaabbbcd");
    }
}
