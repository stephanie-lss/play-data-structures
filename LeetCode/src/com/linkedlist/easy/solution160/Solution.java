package com.linkedlist.easy.solution160;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 11:02
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        while (headA != headB) {
            ListNode cur = headB.next;
            while (cur != null) {
                if (cur == headA) {
                    return cur;
                } else {
                    cur = cur.next;
                }
            }
            headA = headA.next;
            if (headA == null) {
                return null;
            }
        }
        return headA;
    }
}
