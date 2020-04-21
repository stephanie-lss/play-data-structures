package com.array.medium.solution79;

/**
 * @author LiSheng
 * @date 2020/2/27 12:05
 */
public class Solution2 {
    int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + direct[i][0];
                int newY = startY + direct[i][1];
                if (inArea(newX, newY)) {
                    if (!visited[newX][newY]) {
                        if (searchWord(board, word, index + 1, newX, newY)) {
                            return true;
                        }
                    }
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
}
