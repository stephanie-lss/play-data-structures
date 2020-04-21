package com.array.medium.solution106;

import com.TreeNode;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/4/18 12:27
 */
public class Solution {

    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);

    }

    private TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) {
            return null;
        }
        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
