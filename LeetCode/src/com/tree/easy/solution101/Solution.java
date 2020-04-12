package com.tree.easy.solution101;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/23 16:18
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(right.left, left.right);
        }
        return false;
    }
}
