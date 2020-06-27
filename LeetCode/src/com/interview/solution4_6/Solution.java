package com.interview.solution4_6;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/6/27 11:23
 */
class Solution {

    private TreeNode successor = null;
    private boolean next = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return successor;
        }
        inOrder(root, p);
        return successor;
    }

    private void inOrder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        inOrder(root.left, p);
        if (next) {
            successor = root;
            next = false;
            return;
        }
        if (p.val == root.val) {
            next = true;
        }
        inOrder(root.right, p);
    }

    public static void main(String[] args) {
        Integer[] nums = {5,3,6,2,4,null,null,1};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeNode p = new TreeNode(1);
        System.out.println(new Solution().inorderSuccessor(root, p).val);
    }
}