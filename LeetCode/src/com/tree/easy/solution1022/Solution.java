package com.tree.easy.solution1022;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 22:42
 */
public class Solution {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        calculate(root, 0);
        return sum;
    }

    private void calculate(TreeNode node, int num) {
        if (node == null) {
            return;
        }
        num += node.val;
        if (node.right == null && node.left == null) {
            sum += num;
        }
        calculate(node.left, num * 2);
        calculate(node.right, num * 2);
    }
}
