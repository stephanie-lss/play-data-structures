package com.top100.solution560;

/**
 * @author LiSheng
 * @date 2020/5/5 18:03
 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int res = 0,  ref = 0, cur = 0;
        while (ref < nums.length) {
            int tmp = nums[ref];
            while (true) {
                if (tmp == k) {
                    res++;
                }
                if (cur < nums.length - 1) {
                    tmp += nums[++cur];
                } else {
                    cur = ++ref;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 0, 3};
        System.out.println(new Solution2().subarraySum(nums, 3));
    }
}