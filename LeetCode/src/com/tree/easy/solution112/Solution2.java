package com.tree.easy.solution112;

import com.TreeNode;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/25 21:30
 */
public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        root.val = sum - root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right == null && node.left == null && node.val == 0) {
                return true;
            }
            if (node.right != null) {
                node.right.val = sum - node.right.val;
                stack.push(node.right);
            }
            if (node.left != null) {
                node.left.val = sum - node.left.val;
                stack.push(node.left);
            }
        }
        return false;
    }
}
