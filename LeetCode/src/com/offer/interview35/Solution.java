package com.offer.interview35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/5/12 20:32
 */
// Definition for a Node.

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}