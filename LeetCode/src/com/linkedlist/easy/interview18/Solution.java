package com.linkedlist.easy.interview18;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 14:15
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next.val != val) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
