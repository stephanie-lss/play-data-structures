package com.top100.solution406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/28 18:24
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
