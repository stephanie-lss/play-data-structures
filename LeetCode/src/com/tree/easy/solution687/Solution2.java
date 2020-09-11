package com.tree.easy.solution687;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 14:17
 */
class Solution2 {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        return Math.max(Math.max(left, right), Math.max(helper(root.left, root.val), helper(root.right, root.val)));

    }

    private int helper(TreeNode node, int value) {
        if (node == null || node.val != value) return 0;
        return 1 + Math.max(helper(node.left, value), helper(node.right, value));
    }
}