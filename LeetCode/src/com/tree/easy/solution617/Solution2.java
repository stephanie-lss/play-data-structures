package com.tree.easy.solution617;

import com.TreeNode;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/6 22:15
 */
public class Solution2 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            if (node[0] == null || node[1] == null) {
                continue;
            }
            node[0].val += node[1].val;

            if (node[0].left == null) {
                node[0].left = node[1].left;
            } else {
                stack.push(new TreeNode[]{node[0].left, node[1].left});
            }

            if (node[0].right == null) {
                node[0].right = node[1].right;
            } else {
                stack.push(new TreeNode[]{node[0].right, node[1].right});
            }
        }
        return t1;
    }
}
