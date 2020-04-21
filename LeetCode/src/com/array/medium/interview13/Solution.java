package com.array.medium.interview13;

/**
 * @author LiSheng
 * @date 2020/4/8 9:27
 */
public class Solution {
    int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    int count = 0;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    private void dfs(int startX, int startY, int m, int n, int k) {
        if (visited[startX][startY]) {
            return;
        }
        visited[startX][startY] = true;
        int sum = 0;
        int tmpX = startX;
        int tmpY = startY;
        while (startX != 0 || startY != 0) {
            if (startX != 0) {
                sum += startX % 10;
                startX /= 10;
            }
            if (startY != 0) {
                sum += startY % 10;
                startY /= 10;
            }
        }
        if (sum <= k) {
            System.out.println(tmpX + " : " + tmpY);
            count++;
        } else {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = tmpX + direct[i][0];
            int newY = tmpY + direct[i][1];
            if (inArea(newX, newY, m, n)) {
                dfs(newX, newY, m, n, k);
            }
        }
    }

    private boolean inArea(int startX, int startY, int m, int n) {
        return startX >= 0 && startX < m && startY >= 0 && startY < n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(16, 8, 4));
    }
}
