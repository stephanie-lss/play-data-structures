package com.offer.interview56_I;

/**
 * @author LiSheng
 * @date 2020/6/16 8:56
 */
public class Solution2 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int one = res & -res;
        int[] arr = new int[2];
        for (int num : nums) {
            if ((one & num) != 0) {
                arr[0] = num;
                arr[1] = res ^ num;
                break;
            }
        }
        return arr;
    }
}
