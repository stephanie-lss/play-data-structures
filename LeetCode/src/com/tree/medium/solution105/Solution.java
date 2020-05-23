package com.tree.medium.solution105;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/22 8:33
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        for (int i = il; i < ir; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTreeHelper(preorder, inorder, pl + 1, pl + i - il + 1, il, i);
                root.right = buildTreeHelper(preorder, inorder, pl + i - il + 1, pr, i + 1, ir);
            }
        }
        return root;
    }
}