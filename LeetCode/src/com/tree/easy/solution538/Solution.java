package com.tree.easy.solution538;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 19:07
 */
public class Solution {
    Integer pre = null;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        if (pre != null) {
            node.val += pre;
        }
        pre = node.val;
        inOrder(node.left);
    }
}
