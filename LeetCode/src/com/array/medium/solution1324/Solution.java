package com.array.medium.solution1324;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 14:12
 */
public class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] strs = s.split(" ");
        int count = 0;
        while (true) {
            StringBuilder tmp = new StringBuilder();
            String blank = "";
            for (String str : strs) {
                if (count < str.length()) {
                    tmp.append(blank).append(str.charAt(count));
                    blank = "";
                } else {
                    blank += " ";
                }
            }
            if (tmp.length() == 0) {
                break;
            }
            count++;
            res.add(tmp.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "AA BBB C DDDD EEEEE F";
        System.out.println(new Solution().printVertically(str));
    }
}
