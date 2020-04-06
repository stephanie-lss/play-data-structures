package com.solution1111;

/**
 * @author LiSheng
 * @date 2020/4/1 10:24
 */
public class Solution3 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                ans[i] = i % 2;
            } else {
                ans[i] = 1 - i % 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String seq = "()(())()";
        new Solution3().maxDepthAfterSplit(seq);
    }
}
