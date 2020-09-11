package com.top100.solution240;

/**
 * @author LiSheng
 * @date 2020/4/30 12:02
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return false;
        }
        //先用二分查找竖扫,确定在哪一行再进行横扫
        return binarySearchRow(matrix, 0, row, column, target);
    }

    private boolean binarySearchRow(int[][] matrix, int leftRow, int rightRow, int column, int target) {
        while (leftRow < rightRow) {
            int midRow = leftRow + (rightRow - leftRow) / 2;
            if (matrix[midRow][0] > target) {
                //往上缩小行数
                rightRow = midRow;
            } else if (matrix[midRow][0] < target) {
                //有可能出现目标值的行
                //进行二分查找寻找目标值
                if (binarySearchColumn(matrix, 0, column, target, midRow)) {
                    return true;
                }
                //如果没有找到
                return binarySearchRow(matrix, midRow + 1, rightRow, column, target) || binarySearchRow(matrix, leftRow, midRow, column, target);
            } else if (matrix[midRow][0] == target) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchColumn(int[][] matrix, int leftColumn, int rightColumn, int target, int midRow) {
        while (leftColumn < rightColumn) {
            int midColumn = leftColumn + (rightColumn - leftColumn) / 2;
            if (matrix[midRow][midColumn] < target) {
                leftColumn = midColumn + 1;
            } else if (matrix[midRow][midColumn] > target) {
                rightColumn = midColumn;
            } else if (matrix[midRow][midColumn] == target) {
                return true;
            }
        }
        return false;
    }
}
