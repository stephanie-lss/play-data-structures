package com.solution114;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/8/3 9:11
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        tree2List(root);
    }

    private TreeNode tree2List(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = tree2List(root.right);
        TreeNode left = tree2List(root.left);
        root.left = null;
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
        return root;
    }
}
