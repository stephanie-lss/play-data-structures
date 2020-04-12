package com.tree.easy.solution589;

import com.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/7 18:29
 */
public class Solution2 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (!root.children.isEmpty()) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }
        return res;
    }
}
