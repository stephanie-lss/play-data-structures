package com.array.easy.solution1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/28 16:41
 */
public class Solution2 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = ((sum << 1) + A[i]) % 5;
            res.add(sum % 5 == 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1};
//        int[] A = {0, 1, 1};
        new Solution2().prefixesDivBy5(A);
    }
}
