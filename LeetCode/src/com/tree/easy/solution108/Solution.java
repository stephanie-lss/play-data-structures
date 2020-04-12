package com.tree.easy.solution108;

import com.TreeNode;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/2/26 16:24
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        return dfs(0, arr.length - 1, arr);
    }

    private TreeNode dfs(int l, int r, int[] arr) {
        if (l > r) {
            return null;
        }
        int m = r - (r - l) / 2;
        TreeNode root = new TreeNode(arr[m]);

        root.left = dfs(l, m - 1, arr);
        root.right = dfs(m + 1, r, arr);
        return root;
    }
}
