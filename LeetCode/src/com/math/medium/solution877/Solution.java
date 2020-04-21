package com.math.medium.solution877;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/4/16 11:18
 */
public class Solution {
    int alex = 0, li = 0;

    public boolean stoneGame(int[] piles) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int pile : piles) {
            list.add(pile);
        }
        helper(list);
        return alex > li;
    }

    private void helper(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        alex += list.getFirst()>=list.getLast()?list.removeFirst():list.removeLast();
        li += list.getFirst()>=list.getLast()?list.removeLast():list.removeFirst();
        helper(list);
    }

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(new Solution().stoneGame(piles));
    }
}
