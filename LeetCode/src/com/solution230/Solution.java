package com.solution230;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/26 16:05
 */
public class Solution {
    int res = 0;
    int cc = 0;

    public int kthSmallest(TreeNode root, int k) {
        cc = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (--cc == 0) {
            res = node.val;
        }
        inOrder(node.right);
    }
}
