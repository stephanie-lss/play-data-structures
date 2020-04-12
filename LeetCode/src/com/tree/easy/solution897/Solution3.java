package com.tree.easy.solution897;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 20:12
 */
public class Solution3 {
    TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ret = new TreeNode(-1);
        pre = ret;
        inOrder(root);

        return ret.right;
    }


    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = null;
        pre.right = node;
        pre = node;
        inOrder(node.right);
    }
}
