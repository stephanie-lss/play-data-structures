package com.offer.interview55_I;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/12 16:43
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(helper(root.left, depth), helper(root.right, depth)) + 1;
    }
}