package com.offer.interview52;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/13 21:56
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

    public static void main(String[] args) {
        int[] arrB = {5, 0, 1, 8, 4, 5};
        ListNode headB = new ListNode(arrB);
        int[] arrA = {4, 1, 8, 4, 5};
        ListNode headA = new ListNode(arrA);
        System.out.println(new Solution().getIntersectionNode(headA, headB));
    }
}