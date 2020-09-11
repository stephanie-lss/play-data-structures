package com.interview.solution2_7;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/25 12:56
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}