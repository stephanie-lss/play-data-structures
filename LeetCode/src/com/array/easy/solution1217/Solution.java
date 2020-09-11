package com.array.easy.solution1217;

/**
 * @author LiSheng
 * @date 2020/3/31 17:49
 */
public class Solution {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return even > odd ? odd : even;
    }
}
