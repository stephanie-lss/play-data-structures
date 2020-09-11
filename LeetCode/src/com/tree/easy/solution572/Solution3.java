package com.tree.easy.solution572;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/6 20:45
 */
public class Solution3 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return compare(s, t);
    }

    private boolean compare(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || compare(s.left, t) || compare(s.right, t));
    }

    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
}
