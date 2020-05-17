package com.tree.medium.solution98;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/5 9:04
 */
class Solution2 {
    boolean isBSTSearch = true;
    double max = Double.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isBSTSearch;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (max < root.val) {
            max = root.val;
        } else {
            isBSTSearch = false;
            return;
        }
        inOrder(root.right);
    }
}