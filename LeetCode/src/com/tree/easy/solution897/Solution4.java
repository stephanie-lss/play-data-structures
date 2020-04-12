package com.tree.easy.solution897;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 20:12
 */
public class Solution4 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newLeftTree = increasingBST(root.left);
        System.out.println("newLeftTree:"+newLeftTree);
        TreeNode newRightTree = increasingBST(root.right);
        System.out.println("newRightTree:"+newRightTree);
        root.left = null;
        if (newLeftTree == null) {
            root.right = newRightTree;
        }
        if (newRightTree == null) {
            root.right = newLeftTree;
        }

        TreeNode cur = newLeftTree;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = root;
        root.right = newRightTree;
        return newLeftTree;
    }
}
