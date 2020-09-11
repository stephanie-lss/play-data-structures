package com.array.easy.solution1304;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/3/31 21:23
 */
public class Solution {
    public int[] sumZero(int n) {
        int b = n;
        int[] res = new int[n];
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (n > 1) {
            int num = random.nextInt(b);
            while (list.contains(num)) {
                num += 5;
            }
            list.add(num);
            count += num;
            n--;
        }
        list.add(-count);
        int idx = 0;
        for (Integer integer : list) {
            res[idx++] = integer;
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        System.out.println("sum:" + sum);
        return res;
    }

    public static void main(String[] args) {
        new Solution().sumZero(6);
    }
}
