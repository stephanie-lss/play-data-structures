package com.interview.solution4_5;

import com.TreeNode;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/26 13:40
 */
public class Solution {
    private LinkedList<Integer> list;
    private boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        this.list = new LinkedList<>();
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (!list.isEmpty() && list.getLast() >= root.val) {
            flag = false;
            return;
        }
        list.addLast(root.val);
        inOrder(root.right);
    }
}
