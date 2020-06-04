package com.offer.interview13;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/4 9:19
 */
public class Solution3 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int[][] direct = {{1, 0}, {0, 1}};
        int res = 0;
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(0, 0));
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> cor = queue.poll();
            Integer x = cor.getKey();
            Integer y = cor.getValue();
            int sum = x / 10 + x % 10 + y / 10 + y % 10;
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || sum > k) {
                continue;
            }
            visited[x][y] = true;
            res++;
            for (int i = 0; i < 2; i++) {
                queue.add(new AbstractMap.SimpleEntry<>(x + direct[i][0], y + direct[i][1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().movingCount(2,3,1));
    }
}
