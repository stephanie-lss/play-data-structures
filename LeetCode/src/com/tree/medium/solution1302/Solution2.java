package com.tree.medium.solution1302;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/14 20:12
 */
class Solution2 {
    int maxDepth = -1;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (maxDepth < depth) {
            maxDepth = depth;
            sum = root.val;
        } else if (depth == maxDepth) {
            sum += root.val;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
        return sum;
    }
}