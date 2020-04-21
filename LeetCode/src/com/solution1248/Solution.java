package com.solution1248;

/**
 * @author LiSheng
 * @date 2020/4/21 8:56
 * 暴力超时
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        int odd = 0;
        for (int num : nums) {
            odd += num & 1;
            ans += odd >= k ? map[odd - k] : 0;
            map[odd]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,1};
        System.out.println(new Solution().numberOfSubarrays(nums, 2));
    }
}
