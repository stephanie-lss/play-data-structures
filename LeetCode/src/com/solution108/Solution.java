package com.solution108;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/7/3 8:35
 */
class Solution {
    private TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0, right = nums.length;
        return helper(nums, left, right);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode parent = new TreeNode(nums[mid]);
        if (root == null) {
            root = parent;
        }
        parent.left = helper(nums, left, mid);
        parent.right = helper(nums, mid + 1, right);
        return parent;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedArrayToBST(nums));
    }
}