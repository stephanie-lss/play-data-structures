package com.math.medium.solution1104;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/16 19:34
 */
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        res.add(label);
        int c = (int) (Math.log(label) / Math.log(2));
        while (c != 0) {
            label = (int) (Math.pow(2, c) - 1) + (int) (Math.pow(2, c - 1)) - label / 2;
            res.addFirst(label);
            c--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(26));
    }
}
