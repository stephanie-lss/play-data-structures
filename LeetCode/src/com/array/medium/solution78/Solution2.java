package com.array.medium.solution78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/12 19:32
 */
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution2().subsets(nums));
    }
}