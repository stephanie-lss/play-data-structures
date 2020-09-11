package com.interview.solution62;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 9:51
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

    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(10, 17));
    }
}
