package com.math.easy.solution970;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/12 13:09
 */
    public class Solution {

        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 20 && Math.pow(x, i) <= bound; i++) {
                for (int j = 0; j < 20 && Math.pow(y, i) <= bound; j++) {
                    int num = (int) (Math.pow(x, i) + Math.pow(y, j));
                    if (num <= bound) {
                        set.add(num);
                    }
                }
            }
            return new ArrayList<>(set);
        }

        public static void main(String[] args) {
            System.out.println(new Solution().powerfulIntegers(2, 3, 10));
        }
    }
