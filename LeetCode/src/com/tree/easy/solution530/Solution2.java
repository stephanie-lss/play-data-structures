package com.tree.easy.solution530;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/6 18:56
 */
public class Solution2 {
    List<Integer> list = new ArrayList<>();
    Integer pre = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre);
        }
        pre = node.val;
        inOrder(node.right);
    }
}
