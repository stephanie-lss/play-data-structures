package com.solution46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/8 17:12
 */
class Solution3 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, index + 1, list);
                list.removeLast();
                visited[i] = false;
            }
        }
    }
}