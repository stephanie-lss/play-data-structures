package com.top100.solution207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/2 14:15
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(poll)) {
                if (--inDegrees[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] pro = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        int nums = 4;
        System.out.println(new Solution2().canFinish(nums, pro));
    }
}
