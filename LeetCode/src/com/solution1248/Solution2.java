package com.solution1248;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/21 11:04
 */
public class Solution2 {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) {
                list.add(i);
            }
        }
        list.add(n);
        int res = 0;
        for (int i = 1; i + k < list.size(); i++) {
            res += (list.get(i) - list.get(i - 1)) * (list.get(i + k) - list.get(i + k - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(new Solution().numberOfSubarrays(nums, k));
    }
}
