package com.offer.interview36;

/**
 * @author LiSheng
 * @date 2020/6/6 10:10
 */
public class Solution5 {
    private Node ret = null;
    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        ret.left = pre;
        pre.right = ret;
        return ret;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre == null) {
            ret = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inOrder(root.right);
    }
}
