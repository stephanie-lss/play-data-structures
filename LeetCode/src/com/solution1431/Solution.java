package com.solution1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/1 8:50
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0], n = candies.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (extraCandies + candies[i] >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
