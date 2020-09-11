package com.solution5388;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/19 10:50
 */
class Solution {
    public String reformat(String s) {
        boolean flag = true;
        int cur = 0;
        char[] chars = s.toCharArray();
        List<Character> abc = new ArrayList<>();
        List<Character> num = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                abc.add(chars[i]);
            } else {
                num.add(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        if (Math.abs(abc.size() - num.size()) > 1) {
            return "";
        } else {
            for (i = 0; i < abc.size() && i < num.size(); i++) {
                res.append(abc.get(i)).append(num.get(i));
            }
        }
        if (i < abc.size()) {
            return res.append(abc.get(i)).toString();
        } else if (i < num.size()) {
            return num.get(i) + res.toString();
        } else {
            return res.toString();
        }
    }

    public static void main(String[] args) {
        String str = "1229857369";
        System.out.println(new Solution().reformat(str));
    }
}
