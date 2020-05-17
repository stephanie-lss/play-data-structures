package com.offer.interview32_III;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/15 20:48
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                tmp.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            if (reverse) {
                Collections.reverse(tmp);
                res.add(tmp);
            } else {
                res.add(tmp);
            }
            reverse = !reverse;
        }
        return res;
    }
}