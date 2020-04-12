package com.math.easy.solution942;

/**
 * @author LiSheng
 * @date 2020/4/9 20:48
 */
public class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] res = new int[N + 1];
        int right = N;
        int left = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[N] = right;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diStringMatch("DDI"));
    }
}
