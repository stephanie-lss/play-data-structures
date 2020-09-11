package com.offer.interview25;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/12 18:11
 */
class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                break;
            }
            if (l2 == null) {
                pre.next = l1;
                break;
            }
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
        return dummyHead.next;
    }
}