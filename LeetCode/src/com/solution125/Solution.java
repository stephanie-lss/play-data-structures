package com.solution125;

/**
 * @author LiSheng
 * @date 2020/2/18 10:24
 * 对撞指针
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int t = s.length();
        StringBuilder str = new StringBuilder(t);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        String res = str.toString();
        int l = 0,r = res.length()-1;
        while (l < r) {
            if (res.charAt(l++) == res.charAt(r--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(res);
    }
}
