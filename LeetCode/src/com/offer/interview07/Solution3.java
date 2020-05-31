package com.offer.interview07;

import com.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/31 12:51
 */
public class Solution3 {
    private Map<Integer, Integer> record = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            record.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int inRootIdx = record.get(preorder[preL]);
        TreeNode root = new TreeNode(preorder[preL]);
        root.left = buildTreeHelper(preorder, preL + 1, preL + inRootIdx - inL, inL, inRootIdx - 1);
        root.right = buildTreeHelper(preorder, preL + inRootIdx - inL + 1, preR, inRootIdx + 1, inR);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        System.out.println(new Solution3().buildTree(pre, in));
    }
}
