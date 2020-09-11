package com.array.medium.solution1395;

/**
 * @author LiSheng
 * @date 2020/4/12 17:29
 */
public class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if ((rating[i] > rating[j] && rating[j] > rating[k]) || (rating[i] < rating[j] && rating[j] < rating[k])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rating = {1,2,3,4};
        System.out.println(new Solution().numTeams(rating));
    }
}
