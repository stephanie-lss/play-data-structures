package com.offer.interview18;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/2 10:32
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
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
