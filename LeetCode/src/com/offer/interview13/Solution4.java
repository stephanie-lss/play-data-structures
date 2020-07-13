package com.offer.interview13;

/**
 * @author LiSheng
 * @date 2020/7/4 14:10
 */
public class Solution4 {

    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;
    private int M;
    private int N;
    private int K;
    private int count = 0;

    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        this.M = m;
        this.N = n;
        this.K = k;
        this.visited = new boolean[M][N];
        dfs(0, 0);
        return count;
    }

    private void dfs(int x, int y) {
        if (!inArea(x, y) || visited[x][y]) {
            return;
        }
        if (x / 10 + x % 10 + y / 10 + y % 10 <= K) {
            visited[x][y] = true;
            count++;
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
