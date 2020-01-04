package com.solution349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            if (set1.contains(num2)) {
                list.add(num2);
                set1.remove(num2);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}