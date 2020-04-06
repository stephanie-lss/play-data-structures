package com.string.easy.solution606;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/4 11:50
 */
public class Solution {
    private static StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        preOrder(t.left);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        preOrder(t.right);
        return t.val + sb.toString();
    }

    private void preOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        sb.append("(");
        sb.append(t.val);
        if (t.left == null && t.right != null) {
            sb.append("()");
        }
        preOrder(t.left);
        preOrder(t.right);
        sb.append(")");
    }
}
