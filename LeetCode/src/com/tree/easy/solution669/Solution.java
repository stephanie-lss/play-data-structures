package com.tree.easy.solution669;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 12:21
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.right, L, R);
        } else {
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            return root;
        }
    }
}
