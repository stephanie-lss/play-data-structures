package com.tree.easy.solution110;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 20:52
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }
    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.right), maxDepth(node.left)) + 1;
    }
}
