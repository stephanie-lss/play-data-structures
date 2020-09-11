package com.tree.easy.solution897;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 20:12
 */
public class Solution2 {
    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);

        TreeNode newTree = new TreeNode(-1);
        TreeNode cur = newTree;
        for (Integer i : list) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return newTree.right;
    }


    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
