package com.offer.interview26;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/20 22:46
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null) {
            return false;
        }
        if (helper(A, B)) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode A = ConstructTree.constructTree(nums);
        Integer[] nums2 = {4, 8, 9};
        TreeNode B = ConstructTree.constructTree(nums2);
        System.out.println(new Solution().isSubStructure(A, B));
    }
}