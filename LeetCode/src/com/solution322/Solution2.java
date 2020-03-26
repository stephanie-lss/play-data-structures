package com.solution322;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/3/8 11:21
 */
public class Solution2 {
    int res = Integer.MAX_VALUE;
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[coins.length];
        Arrays.fill(memo, -1);
        int count = 0;
        selectCoins(coins, amount, count);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void selectCoins(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            if (memo[i]==-1){
                selectCoins(coins, amount - coins[i], count + 1);
            }
        }
    }

}
