package com.offer.interview62;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/19 8:59
 */
public class Solution3 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int p = 0;
        while (list.size() != 1) {
            p = (p + m - 1) % list.size();
            list.remove(p);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lastRemaining(10, 17));
    }
}
