package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test3 {
    public int maxA(int N) {
        return dp(N, 0, 0);
    }

    private int dp(int n, int nums, int copy) {
        if (n <= 0) {
            return nums;
        }
        //A
        int n1 = dp(n - 1, nums + 1, copy);
        //C_V
        int n2 = dp(n - 1, nums + copy, copy);
        //C_A+C_C
        int n3 = dp(n - 2, nums, nums);
        return Math.max(n1, Math.max(n2, n3));
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(new Test3().maxA(N));
    }
}