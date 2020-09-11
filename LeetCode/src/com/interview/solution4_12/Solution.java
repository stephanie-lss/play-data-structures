package com.interview.solution4_12;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/27 13:14
 */
class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return calPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


    private int calPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int tmp = 0;
        sum -= root.val;
        if (sum == 0) {
            tmp++;
        }
        return tmp + calPathSum(root.left, sum) + calPathSum(root.right, sum);
    }
}