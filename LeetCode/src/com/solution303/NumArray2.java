package com.solution303;

class NumArray2 {

    private int[] sum; //sum[i]存储前i个元素和，sum[0]=0
                       //sum[i]存储nums[0...i-1]中的和

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        int tmp = 0;
        for (int i = 1; i < sum.length; i++) {
            tmp += nums[i - 1];
            sum[i] = tmp;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray2 array = new NumArray2(nums);
        int res1 = array.sumRange(0, 2);
        int res2 = array.sumRange(2, 5);
        int res3 = array.sumRange(0, 5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */