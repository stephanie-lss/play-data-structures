package com.offer.interview35;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/5/12 22:45
 */
public class Solution3 {
    HashMap<Node, Node> memory = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        memory.put(null, null);
        return helper(head);
    }

    private Node helper(Node head) {
        if (memory.containsKey(head)) {
            return memory.get(head);
        }
        Node copyNode = new Node(head.val);
        memory.put(head, copyNode);
        copyNode.next = helper(head.next);
        copyNode.random = helper(head.random);
        return copyNode;
    }
}