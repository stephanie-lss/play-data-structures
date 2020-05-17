package com.offer.interview36;

/**
 * @author LiSheng
 * @date 2020/5/15 15:47
 */
class Solution2 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node cur) {
        if (cur == null) {
            return;
        }
        inOrder(cur.left);

        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        inOrder(cur.right);
    }
}