package com.offer.interview13;

/**
 * @author LiSheng
 * @date 2020/5/20 10:52
 */
class Solution {
    private int[][] direct = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private boolean[][] visited;
    private int res = 0;
    private int X;
    private int Y;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.X = m;
        this.Y = n;
        dfs(0, 0, k);
        return res;
    }

    private void dfs(int x, int y, int k) {
        int tmpX = x, tmpY = y, sum = 0;
        while (tmpX != 0 || tmpY != 0) {
            if (tmpX != 0) {
                sum += tmpX % 10;
                tmpX /= 10;
            }
            if (tmpY != 0) {
                sum += tmpY % 10;
                tmpY /= 10;
            }
        }
        if (sum <= k) {
            visited[x][y] = true;
            res++;
        }else {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inArea(newX, newY) && !visited[newX][newY]) {
                dfs(newX, newY, k);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < X && y < Y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(16, 8, 4));
    }
}