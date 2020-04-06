package com.solution1111;

/**
 * @author LiSheng
 * @date 2020/4/1 10:24
 */
public class Solution2 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int d = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c=='('){
                d += 1;
                ans[i]= d % 2;
            }
            if (c==')'){
                ans[i]= d % 2;
                d -= 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String seq = "(()(())())";
        new Solution2().maxDepthAfterSplit(seq);
    }
}
