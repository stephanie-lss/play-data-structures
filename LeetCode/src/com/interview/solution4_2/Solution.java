package com.interview.solution4_2;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/26 11:18
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildBalanceTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildBalanceTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        if (((right + left) & 1) != 1) {
            mid += 1;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalanceTree(nums, left, mid - 1);
        root.right = buildBalanceTree(nums, mid + 1, right);
        return root;
    }
}