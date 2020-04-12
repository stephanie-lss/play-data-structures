package com.tree.easy.solution872;


import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 19:40
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null) {
            return false;
        } else if (root2 == null) {
            return false;
        }

        List<Integer> res1 = new ArrayList<>();
        preOrder(root1, res1);
        List<Integer> res2 = new ArrayList<>();
        preOrder(root2, res2);
        return res1.equals(res2);
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        preOrder(node.left, list);
        if (node.right == null && node.left == null) {
            list.add(node.val);
        }
        preOrder(node.right, list);
    }
}