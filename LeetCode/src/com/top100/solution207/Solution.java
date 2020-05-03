package com.top100.solution207;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/2 11:39
 * NOT AC
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> record = new HashSet<>();
        record.add(prerequisites[0][0]);
        queue.offer(prerequisites[0][0]);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = graph.get(poll);
            if (list == null) {
                continue;
            }
            for (Integer integer : list) {
                List<Integer> list1 = graph.get(integer);
                if (list1 == null) {
                    record.add(integer);
                    continue;
                }
                for (Integer integer1 : list1) {
                    if (record.contains(integer1)) {
                        return false;
                    } else {
                        queue.offer(integer);
                        record.add(integer);
                    }
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!graph.containsKey(prerequisites[i][0])) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0], list);
            } else {
                List<Integer> list = graph.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        int[][] pro = {{0, 1}, {2, 1}, {1, 2}};
        System.out.println(new Solution().canFinish(3, pro));
    }
}