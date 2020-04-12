package com.tree.easy.solution1022;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 22:42
 */
public class Solution2 {

    public int sumRootToLeaf(TreeNode root) {
        //以root为根节点的二进制和，初始状态sum=0
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = (sum << 1) + node.val;
        if (node.right == null && node.left == null) {
            return sum;
        }
        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
