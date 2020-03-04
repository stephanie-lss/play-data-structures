package com.solution112;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 21:30
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
}
