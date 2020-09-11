package com.offer.interview36;

/**
 * @author LiSheng
 * @date 2020/6/6 10:10
 */
public class Solution4 {
    private Node ret = null;
    private Node pre = null;
    private Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        inOrder(root);
        ret.left = tail;
        tail.right = ret;
        do {
            Node p = tail;
            tail = tail.left;
            tail.right = p;
        } while (tail != ret);
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
            root.left = pre;
        }
        if (root.right != null) {
            tail = root.right;
        } else {
            tail = root;
        }
        pre = root;
        inOrder(root.right);
    }
}
