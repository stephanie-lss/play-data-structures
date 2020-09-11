package com.tree.easy.solution590;

import com.Node;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/7 19:02
 */
public class Solution2 {

    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.addFirst(root.val);
            if (!root.children.isEmpty()) {
                for (Node child : root.children) {
                    stack.push(child);
                }
            }
        }
        return res;
    }
}
