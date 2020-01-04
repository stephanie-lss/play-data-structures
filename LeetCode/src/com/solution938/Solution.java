package com.solution938;

import com.TreeNode;

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
    public int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }
        if (maximum(root) < L) {
            return 0;
        }
        if (minimum(root) > R) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            /*sum += root.val;
            rangeSumBST(root.left, L, R);
            rangeSumBST(root.right, L, R);
            return sum;*/
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }

    private int minimum(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return minimum(node.left);
    }

    private int maximum(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        int maximum = maximum(node.right);
        return maximum;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(0);
        tree.add(18);
        System.out.println(new Solution().rangeSumBST(tree.root, 7, 15));
    }
}