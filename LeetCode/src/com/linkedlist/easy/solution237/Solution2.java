package com.linkedlist.easy.solution237;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/2 11:20
 */
public class Solution2 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
