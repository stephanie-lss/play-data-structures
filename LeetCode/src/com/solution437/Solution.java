package com.solution437;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/26 14:31
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = findPath(root, sum);
        int leftPathSum = pathSum(root.left, sum);
        int rightPathSum = pathSum(root.right, sum);
        res += leftPathSum + rightPathSum;
        return res;
    }

    private int findPath(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == num) {
            res++;
        }
        if (node.left != null) {
            int leftPath = findPath(node.left, num - node.val);
            res += leftPath;
        }
        if (node.right != null) {
            res += findPath(node.right, num - node.val);
        }
        return res;
    }
}
