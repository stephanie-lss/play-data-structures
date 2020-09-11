package com.offer.interview36;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/15 19:42
 */
public class Solution3 {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> stack = new LinkedList<>();
        Node pre = null, head = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.addLast(root);
                root = root.left;
            } else {
                root = stack.removeLast();
                if (pre == null) {
                    //此时是头节点
                    head = root;
                } else {
                    pre.right = root;
                }
                root.left = pre;
                pre = root;
                root = root.right;
            }
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}
