package com.tree.easy.solution897;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 20:12
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        return dfs(0, list.size() - 1);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode newTree = new TreeNode(list.get(l));
        newTree.right = dfs(++l, r);
        return newTree;
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
