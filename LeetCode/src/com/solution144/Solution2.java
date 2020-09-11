package com.solution144;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/2/25 15:01
 */
public class Solution2 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
