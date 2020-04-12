package com.tree.easy.solution965;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 21:15
 */
public class Solution {

    TreeNode pre = null;
    boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        preOrder(root);
        return flag;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (pre != null) {
            if (pre.val != node.val) {
                flag = false;
            }
        }
        pre = node;
        preOrder(pre.left);
        preOrder(pre.right);
    }
}
