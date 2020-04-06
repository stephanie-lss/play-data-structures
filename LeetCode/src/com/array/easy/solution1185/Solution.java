package com.array.easy.solution1185;

/**
 * @author LiSheng
 * @date 2020/3/31 17:04
 */
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }
        return weekday[((day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7)];
    }
}