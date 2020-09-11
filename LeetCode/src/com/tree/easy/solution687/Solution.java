package com.tree.easy.solution687;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 14:17
 */
class Solution {
    private int maxP = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxPath(root);
        return maxP;
    }

    private int getMaxPath(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int leftPath = getMaxPath(t.left);
        int rightPath = getMaxPath(t.right);
        if (t.left == null || t.val != t.left.val) {
            leftPath = 0;
        }
        if (t.right == null || t.val != t.right.val) {
            rightPath = 0;
        }
        maxP = Math.max(maxP, rightPath + leftPath);
        return Math.max(rightPath, leftPath);
    }
}