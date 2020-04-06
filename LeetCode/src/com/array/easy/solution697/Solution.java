package com.array.easy.solution697;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 13:55
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        //度
        int max = Integer.MIN_VALUE;
        //保存原数组
        List<Integer> list = new ArrayList<>();
        //统计数在数组中出现的频次
        int[] freq = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            list.add(nums[i]);
            //统计数组的度
            max = Math.max(max, freq[nums[i]]);
        }

        //保存度为max的数
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == max) {
                list2.add(i);
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer i : list2) {
            //统计度为max且连续子数组最短
            res = Math.min(res, list.lastIndexOf(i) - list.indexOf(i) + 1);
        }
        return res;
    }
}
