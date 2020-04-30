package com.interview.solution8_11;

import java.util.ArrayList;

/**
 * @author LiSheng
 * @date 2020/4/23 9:15
 */
class Solution {

    private int res = 0;
    int[] m = {1, 5, 10, 25};

    public int waysToChange(int n) {
        dfs(new ArrayList<>(), n, 0, 0);
        return res;
    }

    private void dfs(ArrayList<Integer> list, int n, int money, int count) {
        if (money == n) {
            if (!list.contains(count)) {
                res++;
                list.add(count);
            }
            return;
        }
        if (money > n) {
            return;
        }
        for (int i = 0; i < m.length; i++) {
            count++;
            dfs(list, n, money + m[i], count);
            count--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(2000));
    }
}
