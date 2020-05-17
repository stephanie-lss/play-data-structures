package com.tree.hard.solution124;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/7 18:33
 */
class Solution {
    int max = -Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, getMax(root.left));
        int rightSum = Math.max(0, getMax(root.right));
        int sum = root.val + leftSum + rightSum;
        System.out.println(sum+" "+leftSum+" "+rightSum);
        max = Math.max(max, sum);
        return Math.max(rightSum, leftSum) + root.val;
    }

    public static void main(String[] args) {
        Integer[] nums = {9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution().maxPathSum(root));
    }
}