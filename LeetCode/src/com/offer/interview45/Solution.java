package com.offer.interview45;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/16 18:40
 */
class Solution {
    public String minNumber(int[] nums) {
        List<String> str = new ArrayList<>();
        for (int num : nums) {
            str.add(String.valueOf(num));
        }
        str.sort((o1, o2) -> ((o1 + o2).compareTo(o2 + o1)));
        return String.join("", str);
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution().minNumber(nums));
    }
}