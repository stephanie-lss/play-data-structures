package com.tree.easy.solution543;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 19:22
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rootMax = maxDepth(root.right) + maxDepth(root.left);
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(leftMax, rightMax), rootMax);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
