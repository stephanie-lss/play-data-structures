package com.array.medium.solution950;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/4/13 15:29
 */
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];

        Deque<Integer> idx = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }

        int count = 0;
        Arrays.sort(deck);
        while (true) {
            res[idx.poll()] = deck[count++];
            if (idx.isEmpty()) {
                break;
            }
            idx.addLast(idx.removeFirst());
        }
        return res;
    }


    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(new Solution().deckRevealedIncreasing(deck));
    }
}
