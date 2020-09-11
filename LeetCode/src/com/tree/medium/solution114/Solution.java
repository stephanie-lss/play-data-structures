package com.tree.medium.solution114;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/28 14:30
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode leftList = treeToList(root.left);
        TreeNode rightList = treeToList(root.right);
        root.left = null;
        root.right = leftList;
        while (root.right != null) {
            root = root.right;
        }
        root.right = rightList;
    }

    private TreeNode treeToList(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        TreeNode pre = newRoot;
        pre.right = treeToList(root.left);
        while (pre.right != null) {
            pre = pre.right;
        }
        pre.right = treeToList(root.right);
        return newRoot;
    }
}