package com.math.easy.solution1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/9 22:24
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        for (int x = 1; x <= z; x++) {
            binary(customfunction, 1, z, x, z);
        }
        return res;
    }

    private void binary(CustomFunction customfunction, int left, int right, int x, int z) {
        if (left > right) {
            return;
        }
        int mid = (right + left) / 2;
        if (customfunction.f(x, mid) == z) {
            res.add(new ArrayList<>(Arrays.asList(x, mid)));
            return;
        } else if (customfunction.f(x, mid) < z) {
            binary(customfunction, mid + 1, right, x, z);
        } else {
            binary(customfunction, left, mid - 1, x, z);
        }
    }
}