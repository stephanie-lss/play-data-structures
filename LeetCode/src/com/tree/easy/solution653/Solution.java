package com.tree.easy.solution653;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 11:30
 */
public class Solution {
    boolean flag = false;
    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root, k);
        return flag;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        if (list.contains(k - node.val)) {
            flag = true;
            return;
        }
        list.add(node.val);
        inOrder(node.right, k);
    }
}
