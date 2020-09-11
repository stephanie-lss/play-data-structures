package com.tree.medium.solution1302;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/14 20:12
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                root = queue.poll();
                sum += root.val;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            if (queue.isEmpty()) {
                return sum;
            }
        }
        throw null;
    }
}