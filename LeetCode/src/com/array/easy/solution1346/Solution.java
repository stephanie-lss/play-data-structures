package com.array.easy.solution1346;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/1 12:38
 */
public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 10, -19, 4, 6, -8};
        System.out.println(new Solution().checkIfExist(arr));
    }
}
