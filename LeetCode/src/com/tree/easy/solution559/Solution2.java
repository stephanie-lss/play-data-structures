package com.tree.easy.solution559;

import com.Node;

import java.util.AbstractMap;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/7 17:35
 */
class Solution2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        }
        Stack<AbstractMap.SimpleEntry<Node, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<Node, Integer> curDepth = stack.pop();
            root = curDepth.getKey();
            if (!root.children.isEmpty()) {
                depth = Math.max(depth, curDepth.getValue());
                for (Node child : root.children) {
                    stack.push(new AbstractMap.SimpleEntry<>(child, curDepth.getValue() + 1));
                }
            }
        }
        return depth;
    }
}