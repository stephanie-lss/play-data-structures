package com.tree.medium.solution645;

import com.TreeNode;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/30 18:25
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx + 1, nums.length));
        return root;
    }
}