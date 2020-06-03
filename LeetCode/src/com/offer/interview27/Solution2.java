package com.offer.interview27;

import com.TreeNode;
import com.offer.TreeLevel;
import com.tree.ConstructTree;

import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/3 16:31
 */
class Solution2 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = ConstructTree.constructTree(nums);
        root = new Solution2().mirrorTree(root);
        List<Integer> res = TreeLevel.levelOrder(root);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
}