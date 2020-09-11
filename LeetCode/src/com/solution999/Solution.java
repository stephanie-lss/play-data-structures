package com.solution999;

/**
 * @author LiSheng
 * @date 2020/3/26 10:37
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int row = board.length;
        int line = board[0].length;
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (board[i][j] == 'R') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        for (int i = startX; i >= 0; i--) {
            if (board[i][startY] == 'B') {
                break;
            } else if (board[i][startY] == 'p') {
                count++;
                break;
            }
        }
        for (int i = startY; i >= 0; i--) {
            if (board[startX][i] == 'B') {
                break;
            } else if (board[startX][i] == 'p') {
                count++;
                break;
            }
        }
        for (int i = startX; i < line; i++) {
            if (board[i][startY] == 'B') {
                break;
            } else if (board[i][startY] == 'p') {
                count++;
                break;
            }
        }
        for (int i = startY; i < row; i++) {
            if (board[startX][i] == 'B') {
                break;
            } else if (board[startX][i] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }
}
