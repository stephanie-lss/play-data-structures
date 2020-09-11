package com.array.easy.solution1128;

/**
 * @author LiSheng
 * @date 2020/3/31 12:53
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        int[] record = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            int idx = dominoes[i][0] > dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1] : dominoes[i][1] * 10 + dominoes[i][0];
            record[idx]++;
        }
        for (int i : record) {
            count += i * (i - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] dominoed = {{1, 2}, {2, 1}, {2, 2}, {3, 4}, {5, 6}};
        int i = new Solution().numEquivDominoPairs(dominoed);
        System.out.println(i);
    }
}
