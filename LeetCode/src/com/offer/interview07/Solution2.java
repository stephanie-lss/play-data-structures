package com.offer.interview07;

import com.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/13 17:25
 */
class Solution2 {
    Map<Integer, Integer> record;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        record = new HashMap<>();

        return buildTreeHelper(preorder,inorder);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder) {
        int preLen = preorder.length, inLen = inorder.length;
        if (preLen == 0 && inLen == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preLen == 1 && inLen == 1) {
            return root;
        }
        int rootIdx = -1;
        for (int i = 0; i < inLen; i++) {
            if (inorder[i] == preorder[0]) {
                rootIdx = i;
            }
        }
        int[] inLeftTree = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRightTree = Arrays.copyOfRange(inorder, rootIdx + 1, inLen);
        int[] preLeftTree = Arrays.copyOfRange(preorder, 1, inLeftTree.length + 1);
        int[] preRightTree = Arrays.copyOfRange(preorder, inLeftTree.length + 1, preLen);
        root.left = buildTreeHelper(preLeftTree, inLeftTree);
        root.right = buildTreeHelper(preRightTree, inRightTree);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2};
        int[] in = {1, 2};
        new Solution2().buildTree(pre, in);
    }
}