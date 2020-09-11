package com.interview.solution4_5;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/26 13:50
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return checkValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkValidBST(TreeNode root, long rightMin, long leftMax) {
        return root == null || (root.val > rightMin && root.val < leftMax && checkValidBST(root.left, rightMin, root.val) && checkValidBST(root.right, root.val, leftMax));
    }
}
