package com.tree.easy.solution993;

import com.TreeNode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/7 21:33
 */
public class Solution {
    List<Integer> d = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 1));

        while (!stack.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> entry = stack.pop();
            root = entry.getKey();
            if (root.left != null && root.right != null) {
                if (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x) {
                    return false;
                }
            }
            Integer curDepth = entry.getValue();
            if (x == root.val) {
                d.add(curDepth);
            }
            if (y == root.val) {
                d.add(curDepth);
            }
            if (root.left != null) {
                stack.push(new AbstractMap.SimpleEntry<>(root.left, curDepth + 1));
            }
            if (root.right != null) {
                stack.push(new AbstractMap.SimpleEntry<>(root.right, curDepth + 1));
            }
        }
        if (d.size() < 2) {
            return false;
        }
        return d.get(0).equals(d.get(1));
    }
}
