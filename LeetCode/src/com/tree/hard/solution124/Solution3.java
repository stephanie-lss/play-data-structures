package com.tree.hard.solution124;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/6/21 9:19
 */
public class Solution3 {
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calPathSum(root);
        return maxPath;
    }

    private int calPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, calPathSum(root.left));
        int rightSum = Math.max(0, calPathSum(root.right));
        int pathSum = leftSum + rightSum + root.val;
        maxPath = Math.max(maxPath, pathSum);
        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        Integer[] nums = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution3().maxPathSum(root));
    }
}
