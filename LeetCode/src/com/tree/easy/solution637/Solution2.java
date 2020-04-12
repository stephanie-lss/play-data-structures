package com.tree.easy.solution637;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 10:38
 */
public class Solution2 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        dfs(root, 0, sum, count);
        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    public void dfs(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        dfs(t.left, i + 1, sum, count);
        dfs(t.right, i + 1, sum, count);
    }
}
