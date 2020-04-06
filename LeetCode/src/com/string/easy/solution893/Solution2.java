package com.string.easy.solution893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/2 8:18
 */
public class Solution2 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        int[] record = new int[52];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                record[A[i].charAt(j) - 'a' + (i % 2) * 26]++;
            }
            set.add(Arrays.toString(record));
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] arr = {"abc", "acb", "bac", "bca", "cab", "cba"};
        System.out.println(new Solution2().numSpecialEquivGroups(arr));
    }
}
