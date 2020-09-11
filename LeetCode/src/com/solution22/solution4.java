package com.solution22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/9 10:14
 */
class Solution4 {
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<>(Arrays.asList("")));
        res.add(new LinkedList<>(Arrays.asList("()")));
        for (int i = 2; i <= n; i++) {
            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = res.get(j);
                List<String> str2 = res.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String str = "(" + s1 + ")" + s2;
                        tmp.add(str);
                    }
                }
            }
            res.add(tmp);
        }
        return res.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().generateParenthesis(3));
    }
}
