package com.offer.interview32_I;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/4 10:48
 */
public class Solution2 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            res.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
