package com.tree.medium.solution94;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/28 14:16
 */
public class Solution4 {
    private class ColorTreeNode {
        private TreeNode node;
        //0代表白色，1代表黑色
        private int color;

        public ColorTreeNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<ColorTreeNode> stack = new Stack<>();
        stack.push(new ColorTreeNode(root, 0));
        while (!stack.isEmpty()) {
            ColorTreeNode colorNode = stack.pop();
            if (colorNode.color == 0) {
                if (colorNode.node.right != null) {
                    stack.push(new ColorTreeNode(colorNode.node.right, 0));
                }
                stack.push(new ColorTreeNode(colorNode.node, 1));
                if (colorNode.node.left != null) {
                    stack.push(new ColorTreeNode(colorNode.node.left, 0));
                }
            } else {
                res.add(colorNode.node.val);
            }
        }
        return res;
    }
}
