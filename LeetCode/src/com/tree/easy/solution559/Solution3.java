package com.tree.easy.solution559;

import com.Node;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/7 17:35
 */
class Solution3 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        }

        Queue<AbstractMap.SimpleEntry<Node, Integer>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 1));

        int depth = 0;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Node, Integer> curDepth = queue.poll();
            root = curDepth.getKey();
            depth = Math.max(depth, curDepth.getValue());
            if (!root.children.isEmpty()) {
                for (Node child : root.children) {
                    queue.offer(new AbstractMap.SimpleEntry<>(child, depth + 1));
                }
            }
        }
        return depth;
    }
}