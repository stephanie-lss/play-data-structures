package com.offer.interview54;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/12 19:16
 */
class Solution3 {
    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.right, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        helper(root.left, k);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution3().kthLargest(root, 3));
    }
}