package com.solution785;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/7/16 9:01
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        char[] color = new char[graph.length];
        boolean[] visted = new boolean[graph.length];
        queue.offer(0);
        color[0] = 'r';
        visted[0] = true;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < graph[poll].length; i++) {
                if (!visted[graph[poll][i]]) {
                    visted[graph[poll][i]] = true;
                    color[graph[poll][i]] = color[poll] == 'r' ? 'g' : 'r';
                    queue.offer(graph[poll][i]);
                } else {
                    if (color[poll] == color[graph[poll][i]]) {
                        return false;
                    }
                }
            }
            if (queue.isEmpty()) {
                if (++poll == graph.length) {
                    return true;
                }
                queue.offer(poll);
                visted[poll] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{}, {3}, {}, {1}, {}};
        System.out.println(new Solution().isBipartite(graph));
    }
}