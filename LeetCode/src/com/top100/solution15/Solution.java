package com.top100.solution15;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/8 21:21
 * NOT AC
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int i, LinkedList<Integer> list) {
        if (list.size() == 2) {
            int t = -list.get(0) - list.get(1);
            if (list.contains(t)) {
                if (!res.contains(list)) {
                    res.add(new ArrayList<>(list));
                }
            }
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                list.add(nums[j]);
                dfs(nums, j + 1, list);
                list.removeLast();
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-12, -1, 4, -14, 0, 10, 7, -7, -6, 9, 6, -2, 7, 13};
        System.out.println(new Solution().threeSum(nums));
    }
}