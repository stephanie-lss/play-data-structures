package com.interview.solution4_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/26 10:14
 */
class Solution {

    private boolean[] visited;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (target >= n) {
            return false;
        }
        this.visited = new boolean[n];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] g : graph) {
            if (!map.containsKey(g[0])) {
                map.put(g[0], new HashSet<>());
            }
            map.get(g[0]).add(g[1]);
        }
        return dfs(map, start, target);
    }

    private boolean dfs(Map<Integer, HashSet<Integer>> map, int start, int target) {
        if (visited[start]) {
            return false;
        }
        if (start == target) {
            return true;
        }
        HashSet<Integer> next = map.get(start);
        if (next == null) {
            return false;
        }
        for (Integer num : next) {
            if (dfs(map, num, target)) {
                return true;
            }
        }
        visited[start] = true;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println(new Solution().findWhetherExistsPath(5, graph, 0, 4));
    }
}