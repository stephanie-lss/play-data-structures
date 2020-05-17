package com.offer.interview28;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/16 18:13
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, null, 3, null, 3};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution().isSymmetric(root));
    }
}