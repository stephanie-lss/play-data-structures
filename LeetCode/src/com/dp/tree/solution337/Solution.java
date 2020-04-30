package com.dp.tree.solution337;

import com.TreeNode;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/4/25 13:32
 */
public class Solution {

    HashMap<TreeNode, Integer> record = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (record.containsKey(root)) {
            return record.get(root);
        }
        //遍历二叉树
        //抢
        int m1 = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        //不抢
        int m2 = rob(root.left) + rob(root.right);
        int ret = Math.max(m1, m2);
        record.put(root, ret);
        return ret;
    }
}
