package com.tree.solution145;

import com.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/11 22:35
 */
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            res.addFirst(node.val);
            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (node.right != null) {
                stack.addLast(node.right);
            }
        }
        return res;
    }
}
