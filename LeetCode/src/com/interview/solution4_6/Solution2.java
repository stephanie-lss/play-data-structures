package com.interview.solution4_6;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/27 11:51
 */
public class Solution2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode successor = inorderSuccessor(root.left, p);
        return successor == null ? root : successor;
    }
}
