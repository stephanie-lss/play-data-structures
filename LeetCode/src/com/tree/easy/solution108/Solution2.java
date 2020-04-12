package com.tree.easy.solution108;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/26 16:24
 */
public class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);

    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l < r) {
            return null;
        }
        int m = r - (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = dfs(nums, l, m - 1);
        root.right = dfs(nums, m + 1, r);
        return root;
    }
}
