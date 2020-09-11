package com.tree.medium.solution1379;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/14 19:49
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        return helper(cloned, target);
    }

    private TreeNode helper(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val != target.val) {
            TreeNode nodeR = helper(cloned.right, target);
            TreeNode nodeL = helper(cloned.left, target);
            return nodeR != null ? nodeR : nodeL;
        } else {
            return cloned;
        }
    }
}