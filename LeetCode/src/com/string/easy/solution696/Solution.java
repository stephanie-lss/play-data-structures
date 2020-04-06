package com.string.easy.solution696;

/**
 * @author LiSheng
 * @date 2020/4/4 16:52
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                a++;
                if (i + 1 < s.length()) {
                    if (chars[i + 1] != '0' && b != 0) {
                        res += Math.min(a, b);
                        b = 0;
                    }
                } else {
                    res += Math.min(a, b);
                }
            } else {
                b++;
                if (i + 1 < s.length()) {
                    if (chars[i + 1] != '1' && a != 0) {
                        res += Math.min(a, b);
                        a = 0;
                    }
                } else {
                    res += Math.min(a, b);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "00110011";
        System.out.println(new Solution().countBinarySubstrings(str));
    }
}
