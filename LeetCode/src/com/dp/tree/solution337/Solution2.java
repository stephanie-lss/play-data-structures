package com.dp.tree.solution337;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/25 13:32
 */
public class Solution2 {

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int[] ret = new int[2];
        //抢
        ret[0] = root.val + left[1] + right[1];
        //不抢
        ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ret;
    }
}
