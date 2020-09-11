package com.tree.medium.solution98;

import com.TreeNode;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/5 9:56
 */
class Solution4 {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        double tail = -Double.MAX_VALUE;
        while (!linkedList.isEmpty() || root != null) {
            while (root != null) {
                linkedList.add(root);
                root = root.left;
            }
            root = linkedList.removeLast();
            if (tail < root.val) {
                tail = root.val;
            } else {
                return false;
            }
            root = root.right;
        }
        return true;
    }
}