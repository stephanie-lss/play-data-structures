package com.array.easy.solution985;

/**
 * @author LiSheng
 * @date 2020/3/27 23:00
 */
public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = A.length;
        int[] res = new int[n];
        int eSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                eSum += A[i];
            }
        }
        for (int i = 0; i < n; i++) {
            //先判断替换的值是不是偶数
            if (A[queries[i][1]] % 2 == 0) {
                //是偶数
                eSum -= A[queries[i][1]];
            }
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
            //再判断相加之后是否是偶数
            if (A[queries[i][1]] % 2 == 0) {
                //是偶数
                eSum += A[queries[i][1]];
            }
            res[i] = eSum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] ints = new Solution().sumEvenAfterQueries(A, queries);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
/*        int[] A = {5, 1};
        int[][] queries = {{0, 1}, {4, 0}};
        int[] ints = new Solution().sumEvenAfterQueries(A, queries);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }*/
    }
}
