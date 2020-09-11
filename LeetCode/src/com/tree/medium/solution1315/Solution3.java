package com.tree.medium.solution1315;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/30 20:38
 */
class Solution3 {
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(null, null, root);
        return sum;
    }
    private void helper(TreeNode grandParent, TreeNode parent, TreeNode son) {
        if (son == null) {
            return;
        }
        if (grandParent != null && (grandParent.val & 1) == 0) {
            sum += son.val;
        }
        helper(parent, son, son.left);
        helper(parent, son, son.right);
    }
}