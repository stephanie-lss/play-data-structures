package com.math.easy.solution1103;

/**
 * @author LiSheng
 * @date 2020/4/10 11:10
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 0;
        int i = 0;
        while (candies >0) {
            if (candies >= count + 1) {
                res[i] += ++count;
                candies -= count;
            } else {
                res[i] += candies;
                return res;
            }
            if (i == num_people - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().distributeCandies(60,4));
    }
}
