package com.solution139;

import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/25 12:28
 */
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示s中的前i个字符组成的一个或多个串均存在于wordDict中
        boolean[] dp = new boolean[][ s.length() + 1];
        //base case
        dp[0] = true;
        
    }
}
