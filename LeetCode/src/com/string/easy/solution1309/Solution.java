package com.string.easy.solution1309;

/**
 * @author LiSheng
 * @date 2020/4/5 22:33
 */
public class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '#') {
                sb.append((char) (s.charAt(i) - '0' + 96));
            } else {
                StringBuilder builder = new StringBuilder();
                builder.append(s.charAt(i - 2)).append(s.charAt(i - 1));
                sb.append((char) (Integer.valueOf(builder.toString()) + 96));
                i -= 2;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "10#11#12";
        System.out.println(new Solution().freqAlphabets(str));
    }
}
