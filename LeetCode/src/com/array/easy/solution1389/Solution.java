package com.array.easy.solution1389;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/1 14:16
 */
public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        int[] res = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int idx = 0;
        for (Integer i : list) {
            res[idx++] = i;
        }
        return res;
    }
}
