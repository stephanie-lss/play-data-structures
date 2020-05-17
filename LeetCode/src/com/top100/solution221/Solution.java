package com.top100.solution221;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/7 20:25
 */
class Solution {
    int[][] dirct = {{0, 1}, {1, 1}, {1, 0}};
    int max = 0;
    boolean[][] visited;

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
//                    System.out.println((int) matrix[i][j] - 48);
                    visited = new boolean[row][column];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    int sum = 1;
                    max = Math.max(max, sum);
                    OUTER:
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        int tmp = 0;
                        for (int s = 0; s < size; s++) {
                            int[] cor = queue.poll();
                            for (int k = 0; k < dirct.length; k++) {
                                int newX = cor[0] + dirct[k][0];
                                int newY = cor[1] + dirct[k][1];
                                if (inArea(newX, newY, row, column)) {
                                    if (!visited[newX][newY]) {
                                        visited[newX][newY] = true;
                                        if (matrix[newX][newY] == '1') {
                                            queue.offer(new int[]{newX, newY});
                                            tmp++;
                                        } else {
                                            break OUTER;
                                        }
                                    }
                                } else {
                                    break OUTER;
                                }
                            }
                        }
                        sum += tmp;
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        return max;
    }

    private boolean inArea(int x, int y, int row, int column) {
        return x >= 0 && y >= 0 && x < row && y < column;
    }

    public static void main(String[] args) {
        char[][] mat = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '0', '1'}};
        System.out.println(new Solution().maximalSquare(mat));
    }
}