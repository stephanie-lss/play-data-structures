package com.tree.solution145;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/5/11 22:19
 */
class Solution {
    private class ColorNode {
        private TreeNode node;
        private int color;

        public ColorNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, 0));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.color == 0) {
                stack.push(new ColorNode(colorNode.node, 1));
                if (colorNode.node.right != null) {
                    stack.push(new ColorNode(colorNode.node.right, 0));
                }
                if (colorNode.node.left != null) {
                    stack.push(new ColorNode(colorNode.node.left, 0));
                }
            } else {
                res.add(colorNode.node.val);
            }
        }
        return res;
    }
}