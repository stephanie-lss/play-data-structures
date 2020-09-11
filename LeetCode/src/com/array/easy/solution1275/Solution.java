package com.array.easy.solution1275;

/**
 * @author LiSheng
 * @date 2020/3/31 20:48
 */
public class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                //A下棋
                int xA = moves[i][0];
                int yA = moves[i][1];
                grid[xA][yA] = 1;
                for (int j = 0; j < 3; j++) {
                    if (grid[j][0] == 1 && grid[j][1] == 1 && grid[j][2] == 1) {
                        return "A";
                    }
                    if (grid[0][j] == 1 && grid[1][j] == 1 && grid[2][j] == 1) {
                        return "A";
                    }
                }
                if ((grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1) || (grid[2][0] == 1 && grid[1][1] == 1 && grid[0][2] == 1)) {
                    return "A";
                }
            } else {
                //B下棋
                int xB = moves[i][0];
                int yB = moves[i][1];
                grid[xB][yB] = 2;
                for (int j = 0; j < 3; j++) {
                    if (grid[j][0] == 2 && grid[j][1] == 2 && grid[j][2] == 2) {
                        return "B";
                    }
                    if (grid[0][j] == 2 && grid[1][j] == 2 && grid[2][j] == 2) {
                        return "B";
                    }
                }
                if ((grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2) || (grid[2][0] == 2 && grid[1][1] == 2 && grid[0][2] == 2)) {
                    return "B";
                }
            }
        }
        if (moves.length * moves[0].length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}
