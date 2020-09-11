package com.offer.interview57_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/16 9:54
 */
public class Solution3 {
    public int[][] findContinuousSequence(int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            for (int j = i; j <= target / 2 + 1; j++) {
                list.add(j);
                sum += j;
                if (sum == target) {
                    tmp.add(new ArrayList<>(list));
                    list.clear();
                    break;
                } else if (sum > target) {
                    list.clear();
                    break;
                }
            }
        }
        int[][] res = new int[tmp.size()][];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = new int[tmp.get(i).size()];
            for (int j = 0; j < tmp.get(i).size(); j++) {
                res[i][j] = tmp.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 9;
        new Solution3().findContinuousSequence(target);
    }
}
