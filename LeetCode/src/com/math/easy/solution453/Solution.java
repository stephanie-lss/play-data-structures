package com.math.easy.solution453;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/8 16:27
 */
public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += nums[i] - nums[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nusm={1,1};
        System.out.println(new Solution().minMoves(nusm));
    }
}
