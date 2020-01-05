package com.solution303;

class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new NumArray(nums);
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