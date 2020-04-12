package com.tree.easy.solution226;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 20:41
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightTree = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }
}
