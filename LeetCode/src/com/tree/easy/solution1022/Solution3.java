package com.tree.easy.solution1022;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/8 9:15
 */
public class Solution3 {
    public int sumRootToLeaf(TreeNode root) {

        return getSum(root, 0);
    }

    private int getSum(TreeNode t, int sum) {
        if (t == null) {
            return 0;
        }

        sum = sum + t.val;
        if (t.left == null && t.right == null) {
            return sum;
        }
        return getSum(t.left, sum * 2) + getSum(t.right, sum * 2);
    }
}
