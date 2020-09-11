package com.offer.interview13;

/**
 * @author LiSheng
 * @date 2020/6/4 9:05
 */
public class Solution2 {
    private int[][] direct = {{1, 0}, {0, 1}};
    private boolean[][] visited;
    private int res = 0;
    private int M;
    private int N;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.M = m;
        this.N = n;
        dfs(0, 0, k);
        return res;
    }

    private void dfs(int x, int y, int k) {
        if (!inArea(x, y) || visited[x][y]) {
            return;
        }
        if (x / 10 + x % 10 + y / 10 + y % 10 <= k) {
            res++;
            visited[x][y] = true;
            for (int i = 0; i < 2; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                dfs(newX, newY, k);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().movingCount(3,1,0));
    }
}
