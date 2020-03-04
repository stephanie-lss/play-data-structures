package com.solution51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/27 21:08
 */
public class Solution2 {
    int[][] direct = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        if (n == 0) {
            return res;
        }
        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);
        return res;
    }

    private void putQueen(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[i - index + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[i - index + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[i - index + n - 1] = false;
                row.removeLast();
            }
        }
    }
    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res) {
            printBoard(board);
        }
    }
}
