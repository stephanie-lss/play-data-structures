package com.interview.solution8_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/30 18:25
 */
class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        for (int len = 0; len <= nums.length; len++) {
            dfs(nums, 0, len, new LinkedList<>());
        }
        return res;
    }

    private void dfs(int[] nums, int index, int len, LinkedList<Integer> list) {
        if (list.size() == len) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, len, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Solution().subsets(nums);
        for (List<Integer> re : res) {
            for (Integer num : re) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
