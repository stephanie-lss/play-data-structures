package com.array.medium.solution39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/14 18:51
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(new LinkedList<>(), 0, candidates, target);
        return res;
    }

    private void dfs(LinkedList<Integer> list, int pre, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] >= pre) {
                list.add(candidates[i]);
                pre = candidates[i];
            } else {
                continue;
            }
            dfs(list, pre, candidates, target - candidates[i]);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] cad = {2, 3, 5};
        int target = 8;
        System.out.println(new Solution().combinationSum(cad, target));
    }
}
