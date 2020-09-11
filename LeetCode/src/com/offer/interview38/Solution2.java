package com.offer.interview38;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/18 21:30
 */
class Solution2 {

    private List<String> res;

    public String[] permutation(String s) {
        char[] a = s.toCharArray();
        res = new ArrayList<>();
        permute(a, 0);
        return res.toArray(new String[0]);
    }

    private void permute(char[] s, int index) {
        if (index == s.length) {
            res.add(new String(s));
            return;
        }

        for (int i = index; i < s.length; i++) {
            swap(s, index, i);
            permute(s, index + 1);
            swap(s, index, i);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] strings = new Solution2().permutation(str);
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}