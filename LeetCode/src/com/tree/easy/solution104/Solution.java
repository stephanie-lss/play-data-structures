package com.tree.easy.solution104;


import java.util.Random;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //返回以node为根的二叉树的最大深度
    public int maxDepth(Node root) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (root == null) {
            return 0;
        }
        leftDepth = maxDepth(root.left) + 1;

        rightDepth = maxDepth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        Random random = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(1000));
        }
        System.out.println(bst);
        System.out.println("****");
        System.out.println(new Solution().maxDepth(bst.root));
    }
}