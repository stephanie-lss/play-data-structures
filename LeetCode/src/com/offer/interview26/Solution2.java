package com.offer.interview26;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/6/3 16:07
 */
class Solution2 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (helper(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode A = ConstructTree.constructTree(nums);
        Integer[] nums2 = {4, 8, 9};
        TreeNode B = ConstructTree.constructTree(nums2);
        System.out.println(new Solution2().isSubStructure(A, null));
    }
}