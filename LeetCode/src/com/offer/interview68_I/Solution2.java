package com.offer.interview68_I;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/13 17:08
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        throw null;
    }
}
