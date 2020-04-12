package com.tree.easy.solution1022;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/8 9:21
 */
public class Solution4 {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode t, int num) {
        if (t == null) {
            return;
        }

        num = num * 2 + t.val;
        if (t.left == null && t.right == null) {
            sum += num;
        }
        dfs(t.left, num);
        dfs(t.right, num);
    }
}
