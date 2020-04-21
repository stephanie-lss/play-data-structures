package com.array.medium.solution56;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/4/16 9:46
 */
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        LinkedList<int[]> list = intervals.length != 0 ? new LinkedList<>(Arrays.asList(intervals[0])) : new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (list.getLast()[1] >= intervals[i][0]) {
                if (list.getLast()[1] < intervals[i][1]) {
                    list.getLast()[1] = intervals[i][1];
                }
            } else {
                list.add(intervals[i]);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inter = {};
        System.out.println(new Solution2().merge(inter));
    }
}
