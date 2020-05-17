package com.tree.medium.solution98;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/26 15:22
 */
public class Solution {
    double max = -Double.MAX_VALUE;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (node.val > max) {
            max = node.val;
        }else {
            flag = false;
        }
        inOrder(node.right);
    }
}
