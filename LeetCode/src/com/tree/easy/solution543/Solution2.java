package com.tree.easy.solution543;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 19:22
 */
public class Solution2 {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
