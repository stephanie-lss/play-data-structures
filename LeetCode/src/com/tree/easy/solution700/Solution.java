package com.tree.easy.solution700;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 19:19
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
