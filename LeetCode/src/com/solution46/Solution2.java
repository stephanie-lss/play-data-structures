package com.solution46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/25 0:14
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        this.visited = new boolean[nums.length];
        helper(new LinkedList<>(), nums, nums.length);
        return res;
    }

    private void helper(LinkedList<Integer> list, int[] nums, int n) {
        if (list.size() == n) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                helper(list, nums, n);
                visited[i] = false;
                list.removeLast();
            }
        }
    }
}
