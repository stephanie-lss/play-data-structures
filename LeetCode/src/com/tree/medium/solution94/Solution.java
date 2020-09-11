package com.tree.medium.solution94;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/28 11:20
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(res, root);
        return res;
    }

    private void inOrder(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);
    }
}