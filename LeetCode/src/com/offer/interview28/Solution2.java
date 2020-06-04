package com.offer.interview28;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/4 8:45
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }
}
