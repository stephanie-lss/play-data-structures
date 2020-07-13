package com.solution350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/7/13 8:51
 */
public class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            set.add(i);
        }
        int tmp = 0;
        for (int i : nums1) {
            if (!set.contains(i)) {
                tmp = i;
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (list.indexOf(num) != -1) {
                res.add(num);
                list.set(list.indexOf(num), tmp);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
