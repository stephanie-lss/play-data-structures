package com.offer.interview52;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/13 11:15
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        if (curA != null) {
            curB = headA;
            while (curA != null) {
                curB = curB.next;
                curA = curA.next;
            }
            curA = headB;
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            curA = headB;
            while (curB != null) {
                curA = curA.next;
                curB = curB.next;
            }
            curB = headA;
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return curA;
    }
}
