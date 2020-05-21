package com.offer.interview12;

/**
 * @author LiSheng
 * @date 2020/5/21 17:32
 */
class Solution {

    private int[][] direct = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        this.visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (board[x][y] == word.charAt(index)) {
            if (index + 1 == word.length()) {
                return true;
            }
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                if (inArea(newX, newY, board.length, board[0].length) && !visited[newX][newY]) {
                    if (dfs(board, newX, newY, word, index + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(board, "ABCCEE"));
    }
}