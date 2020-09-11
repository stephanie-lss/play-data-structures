package com.array.medium.solution56;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/16 9:46
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        for (int i = 0; i < list.size() - 1;) {
            if (list.get(i)[1] >= list.get(i + 1)[0]) {
                if (list.get(i)[1] < list.get(i + 1)[1]) {
                    list.get(i)[1] = list.get(i + 1)[1];
                }
                list.remove(i + 1);
            } else {
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inter = {{1, 4}, {0, 2}, {3, 5}};
        System.out.println(new Solution().merge(inter));
    }
}
