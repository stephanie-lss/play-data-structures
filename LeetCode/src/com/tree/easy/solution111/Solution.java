package com.tree.easy.solution111;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 20:33
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 || rightDepth == 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
