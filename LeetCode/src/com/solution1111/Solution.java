package com.solution1111;

/**
 * @author LiSheng
 * @date 2020/4/1 10:24
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int count = 0;
        int[] depth = new int[seq.length()];
//        int[] depthRight = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                count++;
                res[i] = depth[i] % 2;
            } else if (c == ')') {
                res[i] = depth[i] % 2;
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String seq = "()(())()";
        new Solution().maxDepthAfterSplit(seq);
    }
}
