package com.top100.solution279;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/1 14:22
 */
class Solution {
    public int numSquares(int n) {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(n, 1));
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> entry = queue.poll();
            n = entry.getKey();
            int step = entry.getValue();
            if (n == 0 || n - (int) Math.sqrt(n) * (int) Math.sqrt(n) == 0) {
                return step;
            }
            for (int i = (int) Math.sqrt(n); n - i * i >= 0; i--) {
                if (!visited[n - i * i]) {
                    visited[n - i * i] = true;
                    queue.offer(new AbstractMap.SimpleEntry<>(n - i * i, step + 1));
                }
            }
        }
        throw null;
    }
}
