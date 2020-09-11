package com.tree.easy.solution404;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 21:56
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
