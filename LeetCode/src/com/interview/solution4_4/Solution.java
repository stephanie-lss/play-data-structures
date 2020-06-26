package com.interview.solution4_4;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/26 13:22
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkBalanced(root);
    }

    private boolean checkBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            return checkBalanced(root.left) && checkBalanced(root.right);
        } else {
            return false;
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}