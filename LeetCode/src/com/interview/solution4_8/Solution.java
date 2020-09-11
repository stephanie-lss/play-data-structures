package com.interview.solution4_8;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/27 11:58
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else {
                return left == null ? right : left;
            }
        }
    }
}
