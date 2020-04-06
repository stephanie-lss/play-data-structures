package com.array.easy.solution977;

/**
 * @author LiSheng
 * @date 2020/3/27 22:33
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
//        if (A.length == 2) {
//            int a = A[0] * A[0];
//            int b = A[1] * A[1];
//            if (a >= b) {
//                A[1] = a;
//                A[0] = b;
//            } else {
//                A[1] = b;
//                A[0] = a;
//            }
//            return A;
//        }

        int head = 0;
        int tail = A.length - 1;
        int count = A.length - 1;
        int[] res = new int[A.length];
        while (head != tail) {
            if (Math.abs(A[head]) > Math.abs(A[tail])) {
                res[count--] = A[head] * A[head];
                head++;
            } else if (Math.abs(A[head]) < Math.abs(A[tail])) {
                res[count--] = A[tail] * A[tail];
                tail--;
            } else {
                res[count--] = A[tail] * A[tail];
                tail--;
            }
        }
        res[0] = A[head] * A[head];
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-1};
        int[] B = {-2, 2,3};
        int[] C = {-1,1};
        int[] ints = new Solution().sortedSquares(A);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        System.out.println();
        int[] ints1 = new Solution().sortedSquares(B);
        for (int i : ints1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        int[] ints2 = new Solution().sortedSquares(C);
        for (int i : ints2) {
            System.out.print(i + " ");
        }
    }
}
