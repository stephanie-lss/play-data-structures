package com.solution1371;

/**
 * @author LiSheng
 * @date 2020/5/20 10:08
 */
class Solution2 {
    public int findTheLongestSubstring(String s) {
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        //元音字母对应的二进制数
        int[] nums = new int[]{16, 8, 4, 2, 1};
        //dp[i][j]表示前i个字母对应的最长字符子串，j表示s.charAt(i)的个数的状态
        int[][] dp = new int[s.length() + 1][32];
        //base case
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < 32; j++) {
                dp[i][j] = -1;
            }
        }
        //前0个字符对应的长度为0
        dp[0][0] = 0;
        //保存最大值
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            //标志是否是元音字母
            boolean found = false;
            //进行判断
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == s.charAt(i)) {
                    //是元音字母
                    found = true;
                    //判断该字符的个数是否是奇数个
                    for (int k = 0; k < 32; k++) {
                        if (dp[i][k] != -1) {
                            //如果k ^ nums[j] != 0表示以该字母作为首次出现的元音字母，因此第i+1个字符的前缀和=第i个字符的前缀和+1，主要为了应付同一个元音字母出现第三次时的情况
                            //如果k ^ nums[j] == 0表示该元音字母已经出现了一次，表示前i+1个字符对应的最大字串长度为第i个字符的前缀和+1
                            dp[i + 1][k ^ nums[j]] = dp[i][k] + 1;
                        }
                    }
                    //如果该元音字母是第一次出现，则前i+1个字符对应的最大字串长度为0
                    //
                    dp[i + 1][0] = Math.max(0, dp[i + 1][0]);
                }
            }
            //如果是非元音字母
            if (!found) {
                //直接+1即可
                dp[i + 1][0] = dp[i][0] + 1;
                //传递状态，各个元音字母对应的前缀和
                for (int k = 1; k < 32; k++) {
                    if (dp[i][k] != -1) {
                        dp[i + 1][k] = dp[i][k] + 1;
                    }
                }
            }
            result = Math.max(result, dp[i + 1][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "lece";
        System.out.println(new Solution2().findTheLongestSubstring(str));
    }
}
