package com.math.easy.solution1154;

/**
 * @author LiSheng
 * @date 2020/4/12 10:07
 */
public class Solution {
    public int dayOfYear(String date) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strings = date.split("-");
        Integer year = Integer.valueOf(strings[0]);
        Integer month = Integer.valueOf(strings[1]);
        for (int i = 1; i < month; i++) {
            days[0] += days[i];
        }
        days[0] += Integer.valueOf(strings[2]);
        if (year % 400 == 0 || year % 4 == 0 && month > 2) {
            days[0] += 1;
        }
        return days[0];
    }
}
