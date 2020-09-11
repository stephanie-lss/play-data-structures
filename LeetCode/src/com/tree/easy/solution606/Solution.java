package com.tree.easy.solution606;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 22:08
 */
public class Solution {
    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }

        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        preOrder(t.left);
        preOrder(t.right);
        return t.val + sb.toString();
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        sb.append("(");
        sb.append(node.val);
        if (node.left == null && node.right != null) {
            sb.append("()");
        }
        preOrder(node.left);
        preOrder(node.right);
        sb.append(")");
    }
}
