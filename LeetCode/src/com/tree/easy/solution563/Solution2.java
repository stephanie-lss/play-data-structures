package com.tree.easy.solution563;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 20:19
 */
public class Solution2 {
    int res;

    public int findTilt(TreeNode root) {
        treeSum(root);
        return res;
    }

    private int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        res += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
