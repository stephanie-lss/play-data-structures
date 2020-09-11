package com.offer.interview32_I;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/13 22:09
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            res.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}