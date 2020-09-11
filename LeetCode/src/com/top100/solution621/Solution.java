package com.top100.solution621;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/2 18:42
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, (o1, o2) -> o2 - o1);
        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                res++;
                if (pq.isEmpty() && temp.isEmpty()) {
                    break;
                }
                i++;
            }
            for (Integer t : temp) {
                pq.offer(t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = {'B', 'B', 'A', 'A', 'A', 'C', 'C'};
        int n = 2;
        System.out.println(new Solution().leastInterval(tasks, n));
    }
}