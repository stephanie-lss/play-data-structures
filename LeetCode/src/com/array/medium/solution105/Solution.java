package com.array.medium.solution105;

import com.TreeNode;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/4/18 13:34
 */
public class Solution {
    HashMap<Integer, Integer> mapper = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            mapper.put(inorder[i], i);
        }
        pre = preorder;
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        int root = pre[ps];
        int ri = mapper.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(ps + 1, ps + 1 + ri - is, is, ri - 1);
        node.right = buildTree(ps + ri - is + 2, pe, ri + 1, ie);
        return node;
    }
}
