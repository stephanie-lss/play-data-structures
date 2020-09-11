package com.string.easy.solution925;

/**
 * @author LiSheng
 * @date 2020/4/5 15:18
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < typed.length(); i++) {
            if (name.charAt(idx) == typed.charAt(i)) {
                idx++;
            }
            if (idx == name.length()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String name = "leelee";
        String typed = "lleeelee";
        System.out.println(new Solution().isLongPressedName(name, typed));
    }
}
