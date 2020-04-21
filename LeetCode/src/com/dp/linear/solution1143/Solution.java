package com.dp.linear.solution1143;

/**
 * @author LiSheng
 * @date 2020/4/20 13:55
 * 递归,运行时长无法通过
 */
class Solution {

    private int max = 0;

    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0);
    }

    private int helper(String text1, String text2, int count) {
        if ("".equals(text1) || "".equals(text2)) {
            return count;
        }
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    max = Math.max(max, helper(text1.substring(i + 1), text2.substring(j + 1), count + 1));
                } else {
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("pcbmdupybalwpkbidypqbwhefijytypwdwbsharqdurkrslqlqla", "jodcpirubsryvudgpwncrmtypatunqpkhehuhkdmbctyxghsfktaz"));
    }
}
