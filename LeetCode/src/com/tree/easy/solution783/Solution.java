package com.tree.easy.solution783;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 19:25
 */
public class Solution {

    private int dis = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return dis;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            dis = Math.min(dis, Math.abs(root.val - pre.val));
        }
        pre = root;
        inOrder(root.right);

    }
}
