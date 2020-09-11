package com.tree.medium.solution1315;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/30 19:17
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if ((root.val & 1) == 0) {
            //该节点为偶数，只要找到该节点的孙子结点即可
            sum += calSunzi(root);
        }
        sum += sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        return sum;
    }

    private int calSunzi(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 2;
        while (!queue.isEmpty()) {
            count--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (count == 0) {
                break;
            }
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            ret += queue.poll().val;
        }
        return ret;
    }
}