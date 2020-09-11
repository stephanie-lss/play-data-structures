package com.linkedlist.easy.solution21;

/**
 * @author LiSheng
 * @date 2020/5/1 9:10
 */
class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;

        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
                pre = pre.next;
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        } else {
            pre.next = l2;
        }
        return dummyHead.next;
    }
}
