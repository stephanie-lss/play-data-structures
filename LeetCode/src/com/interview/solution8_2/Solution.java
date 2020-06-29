package com.interview.solution8_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/29 17:09
 */
class Solution {
    private int[][] direct = {{0, 1}, {1, 0}};
    private boolean[][] visited;
    private List<List<Integer>> path;
    private int[][] grid;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.path = new ArrayList<>();
        this.grid = obstacleGrid;
        int row = obstacleGrid.length;
        if (row == 0) {
            return path;
        }
        int col = obstacleGrid[0].length;
        this.visited = new boolean[row][col];
        dfs(0, 0, row - 1, col - 1);
        return path;
    }

    private boolean dfs(int x, int y, int endX, int endY) {
        if (x > endX || y > endY || visited[x][y] || grid[x][y] == 1) {
            return false;
        }
        visited[x][y] = true;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.add(y);
        path.add(tmp);
        if (x == endX && y == endY) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (dfs(newX, newY, endX, endY)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[][] obt = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        List<List<Integer>> path = new Solution().pathWithObstacles(obt);
        for (List<Integer> list : path) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}