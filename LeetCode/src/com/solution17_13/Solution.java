package com.solution17_13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/7/9 19:06
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>(Arrays.asList(dictionary));

        //dp[i]表示句子中的前i个字符的最少匹配字符数
        int[] dp = new int[sentence.length() + 1];
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dic.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[sentence.length()];
    }

    public static void main(String[] args) {
        String sec = "jesslookedjustliketimherbrother";
        String[] dic = {"looked", "just", "like", "her", "brother"};
        System.out.println(new Solution().respace(dic, sec));
    }
}
