package com.solution210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/17 9:18
 */
class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cou : prerequisites) {
            graph.get(cou[1]).add(cou[0]);
            indegrees[cou[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            Integer tmp = queue.poll();
            res[idx++] = tmp;
            numCourses--;
            for (Integer num : graph.get(tmp)) {
                if (--indegrees[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        return numCourses != 0 ? new int[0] : res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 0}, {0, 1}};
        int[] order = new Solution2().findOrder(2, nums);
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
}