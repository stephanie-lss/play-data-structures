package com.top100.solution207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/2 14:37
 */
public class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer adj : adjacency.get(i)) {
            if (!dfs(adjacency, flags, adj)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
