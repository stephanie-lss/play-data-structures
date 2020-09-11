package com.offer.interview62;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/15 20:17
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int start = 0;
        while (list.size() != 1) {
            int size = list.size();
            int next = (m + start - 1) % size;
            list.remove(next);
            start = next;
        }
        return list.get(0);
    }
}