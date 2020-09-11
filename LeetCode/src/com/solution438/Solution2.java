package com.solution438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/19 10:47
 */
public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = p.length() - 1;
        while (r < s.length()) {
            int[] freq = getFreq(s.substring(l, r + 1));
            if (isSame(freq, p)) {
                res.add(l);
            }
            l++;
            r++;
        }
        return res;
    }

    private boolean isSame(int[] freq, String p) {
        char[] cs = p.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (freq[cs[i]-97] == 0) {
                return false;
            }else {
                freq[cs[i]-97]--;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (freq[cs[i]-97] != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] getFreq(String p) {
        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)-97]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution2().findAnagrams("abab", "ab");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
