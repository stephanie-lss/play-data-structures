package com.offer.interview25;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 15:45
 */
public class Solution4 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            ListNode head = new ListNode(l2.val);
            head.next = mergeTwoLists(l1, l2.next);
            return head;
        } else{
            ListNode head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next, l2);
            return head;
        }
    }
}
