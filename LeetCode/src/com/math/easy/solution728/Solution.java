package com.math.easy.solution728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/8 19:29
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = true;
            if (i % 10 == 0) {
                continue;
            }
            int num = i;
            while (num != 0) {
                int s = num % 10;
                if (s == 0 || i % s != 0) {
                    flag = false;
                    break;
                }
                num /= 10;
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().selfDividingNumbers(1, 10000);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
