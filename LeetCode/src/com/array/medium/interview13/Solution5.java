package com.array.medium.interview13;

/**
 * @author LiSheng
 * @date 2020/4/15 11:45
 */
class Solution5 {
    private int[][] direct = {{1, 0}, {0, 1}};
    private boolean[][] visited;
    private int count = 1;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        visited[0][0] = true;
        dfs(0, 0, m, n, k);
        return count;
    }

    private void dfs(int x, int y, int m, int n, int k) {
        for (int i = 0; i < 2; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inArea(m, n, newX, newY) && !visited[newX][newY] && (newX / 10 + newX % 10 + newY / 10 + newY % 10 <= k)) {
                System.out.println(newX + " " + newY);
                count++;
                visited[newX][newY] = true;
                dfs(newX, newY, m, n, k);
            }
        }
    }

    private boolean inArea(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().movingCount(7, 2, 3));
    }
}