package com.tree.medium.solution701;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/17 21:31
 */
class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.left;
                }
            } else if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return root;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
}