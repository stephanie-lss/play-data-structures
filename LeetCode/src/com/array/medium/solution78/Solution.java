package com.array.medium.solution78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/12 19:00
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums, new LinkedList<>());
        return res;
    }

    private void helper(int i, int[] nums, LinkedList<Integer> tmp) {
        res.add(new LinkedList<>(tmp));

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            helper(j + 1, nums, tmp);
            tmp.removeLast();
        }
    }

}
