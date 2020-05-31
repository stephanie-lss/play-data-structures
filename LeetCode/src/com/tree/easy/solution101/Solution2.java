package com.tree.easy.solution101;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/31 12:12
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);

    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
        } else {
            return false;
        }
    }
}
