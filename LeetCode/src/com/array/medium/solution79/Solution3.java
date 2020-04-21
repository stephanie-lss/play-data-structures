package com.array.medium.solution79;

/**
 * @author LiSheng
 * @date 2020/4/15 20:50
 */
public class Solution3 {

    private int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                if (board[j][k] == word.charAt(0)) {
                    visited[j][k] = true;
                    if (dfs(board, j, k, row, col, word.substring(1))) {
                        return true;
                    }
                    visited[j][k] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int row, int col, String word) {
        if ("".equals(word)) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            if (inArea(newX, newY, row, col) && !visited[newX][newY] && word.charAt(0) == board[newX][newY]) {
                visited[newX][newY] = true;
                if (dfs(board, newX, newY, row, col, word.substring(1))) {
                    return true;
                }
                visited[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "ABCESEEEFS";
        System.out.println(new Solution3().exist(board, word));
    }
}
