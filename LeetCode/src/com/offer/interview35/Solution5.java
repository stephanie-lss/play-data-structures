package com.offer.interview35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/5 11:24
 */
public class Solution5 {
    private Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        this.map = new HashMap<>();
        map.put(null, null);
        return helper(head);
    }

    private Node helper(Node head) {
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node dup = new Node(head.val);
        map.put(head, dup);
        dup.next = helper(head.next);
        dup.random = helper(head.random);
        return dup;
    }
}
