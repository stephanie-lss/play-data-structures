package com.tree.easy.solution110;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 20:52
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(rightDepth - leftDepth) == 0 || Math.abs(rightDepth - leftDepth) == 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }

    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

}
