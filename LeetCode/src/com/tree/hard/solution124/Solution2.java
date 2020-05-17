package com.tree.hard.solution124;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/7 20:23
 */
class Solution2 {
    int max = -Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        if (rightSum > 0 && leftSum > 0) {
            sum += leftSum + rightSum;
        } else if (rightSum > 0) {
            sum += rightSum;
            leftSum = 0;
        } else if (leftSum > 0) {
            sum += leftSum;
            rightSum = 0;
        } else {
            leftSum = 0;
            rightSum = 0;
        }
        max = Math.max(max, sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}