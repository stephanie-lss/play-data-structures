package com.string.easy.solution434;

/**
 * @author LiSheng
 * @date 2020/4/3 18:51
 */
public class Solution {
    public int countSegments(String s) {
        String[] s1 = s.split("\\s");
        int count = 0;
        for (String c : s1) {
            if (!"".equals(c)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("Hello, my      name is John"));
    }
}
