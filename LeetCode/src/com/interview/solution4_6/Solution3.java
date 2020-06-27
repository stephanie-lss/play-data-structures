package com.interview.solution4_6;

import com.TreeNode;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/27 11:53
 */
public class Solution3 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        boolean next = false;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                if (next) {
                    return root;
                }
                if (p == root) {
                    next = true;
                }
                root = root.right;
            }
        }
        return null;
    }
}
