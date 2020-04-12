package com.tree.easy.solution563;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 20:19
 */
public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootTilt = Math.abs(treeSum(root.left) - treeSum(root.right));
        return findTilt(root.left) + findTilt(root.right) + rootTilt;
    }

    private int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }
}
