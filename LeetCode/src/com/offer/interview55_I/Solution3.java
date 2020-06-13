package com.offer.interview55_I;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/13 12:43
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
