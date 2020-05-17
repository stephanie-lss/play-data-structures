package com.offer.interview27;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/11 21:55
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(tmp);
        return root;
    }
}