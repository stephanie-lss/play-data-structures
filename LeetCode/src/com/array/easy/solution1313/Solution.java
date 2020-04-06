package com.array.easy.solution1313;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/31 13:41
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            while (nums[i]-- > 0) {
                res.add(nums[i + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (Integer integer : res) {
            arr[idx++] = integer;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        System.out.println(new Solution().decompressRLElist(nums));
    }
}
