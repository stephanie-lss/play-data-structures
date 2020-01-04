package com.solution350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i])) {
                map1.put(nums1[i], 1);
            } else {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map2.containsKey(nums2[i])) {
                map2.put(nums2[i], 1);
            } else {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : map2.keySet()) {
            if (map1.containsKey(key)) {
                for (int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++) {
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}