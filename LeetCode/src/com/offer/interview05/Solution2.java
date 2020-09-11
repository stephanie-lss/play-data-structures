package com.offer.interview05;

/**
 * @author LiSheng
 * @date 2020/5/29 20:52
 */
class Solution2 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' '){
                sb.append(c);
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}