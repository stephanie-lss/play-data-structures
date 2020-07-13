package com.solution112;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/7/7 18:56
 */
class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                return true;
            } else {
                return false;
            }
        }
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}