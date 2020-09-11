package com.array.easy.solution448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/28 22:07
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length + 1];
        Arrays.fill(arr, 0);
        for (int num : nums) {
            arr[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (arr[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
