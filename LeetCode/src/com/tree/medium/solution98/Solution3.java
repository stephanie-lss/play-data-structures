package com.tree.medium.solution98;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/5 9:47
 */
public class Solution3 {
    double tail = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (tail < root.val) {
                tail = root.val;
            } else {
                return false;
            }
            return isValidBST(root.right);
        }
        return false;
    }
}
