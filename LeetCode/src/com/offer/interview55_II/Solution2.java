package com.offer.interview55_II;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/15 11:09
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else {
                return false;
            }
        } else if (root.left != null) {
            if (maxDepth(root.left) <= 1) {
                return isBalanced(root.left);
            } else {
                return false;
            }
        } else if (root.right != null) {
            if (maxDepth(root.right) <= 1) {
                return isBalanced(root.right);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
