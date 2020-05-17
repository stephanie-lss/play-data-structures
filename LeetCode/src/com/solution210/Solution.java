package com.solution210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/17 9:18
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
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

        while (!queue.isEmpty()) {
            Integer tmp = queue.poll();
            res.add(tmp);
            List<Integer> list = graph.get(tmp);
            for (Integer num : list) {
                if (--indegrees[num] == 0) {
                    queue.offer(num);
                }
            }
        }
        if (res.size() == numCourses) {
            return res.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 0}, {0, 1}};
        int[] order = new Solution().findOrder(2, nums);
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
}