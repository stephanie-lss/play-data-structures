package com.array.hard.solution466;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/4/19 9:23
 */
public class Solution2 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        char[] sC1 = s1.toCharArray();
        char[] sC2 = s2.toCharArray();
        int l1 = sC1.length;
        int l2 = sC2.length;
        int t1 = 0;
        int t2 = 0;
        int cur = 0;
        Map<Integer, int[]> map = new HashMap<>();
        while (t1 < n1) {
            for (int i = 0; i < l1; i++) {
                if (sC1[i] == sC2[cur]) {
                    cur++;
                    if (cur == l2) {
                        cur = 0;
                        t2++;
                    }
                }
            }
            t1++;
            if (!map.containsKey(cur)) {
                map.put(cur, new int[]{t1, t2});
            } else {
                int[] last = map.get(cur);
                int c1 = t1 - last[0];
                int c2 = t2 - last[1];
                t2 += c2 * ((n1 - t1) / c1);
                t1 += ((n1 - t1) / c1) * c1;
            }
        }
        return t2 / n2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().getMaxRepetitions("abaacdbac", 100, "adcbd", 4));
    }
}