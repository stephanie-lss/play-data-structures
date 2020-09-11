package com.array.medium.solution49;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 12:39
 */
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[] hashCode = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            hash(strs[i],hashCode,i);
        }
        return res;
    }

    private void hash(String str, int[] hashCode, int index) {

    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution2().groupAnagrams(strs));
    }
}
