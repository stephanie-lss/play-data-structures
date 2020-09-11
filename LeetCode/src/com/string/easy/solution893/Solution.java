package com.string.easy.solution893;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/2 8:18
 */
public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] count = new int[52];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] arr = {"abc", "acb", "bac", "bca", "cab", "cba"};
        System.out.println(new Solution().numSpecialEquivGroups(arr));
    }
}
