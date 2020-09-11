package com.offer.interview55_II;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/16 15:55
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }else {
            return false;
        }
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        } else if (root.left != null) {
            return depth(root.left) + 1;
        } else {
            return depth(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode tree = ConstructTree.constructTree(nums);
        System.out.println(new Solution().isBalanced(tree));
    }
}