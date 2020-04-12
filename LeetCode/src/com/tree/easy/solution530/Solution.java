package com.tree.easy.solution530;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/6 18:56
 */
public class Solution {
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) < min) {
                min = list.get(i + 1) - list.get(i);
            }
        }
        return min;
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
