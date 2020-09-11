package com.linkedlist.easy.interview24;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 14:10
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newTail = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = newTail;
            newTail = head;
            head = next;
        }
        return head;
    }
}
