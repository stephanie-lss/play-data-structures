package com.zhousai.one;

/**
 * @author LiSheng
 * @date 2020/4/18 15:01
 */
class Solution {
    public int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            res += coins[i] / 2 + coins[i] % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] co={4,2,1};
        int[] co2={2,3,10};
        System.out.println(new Solution().minCount(co));
        System.out.println(new Solution().minCount(co2));
    }
}
