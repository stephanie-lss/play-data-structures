package com.offer.interview55_I;

import com.TreeNode;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/13 12:53
 */
public class Solution4 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 1));
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> cur = queue.poll();
            maxDepth = Math.max(maxDepth, cur.getValue());
            if (cur.getKey().left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(cur.getKey().left, cur.getValue() + 1));
            }
            if (cur.getKey().right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(cur.getKey().right, cur.getValue() + 1));
            }
        }
        return maxDepth;
    }
}
