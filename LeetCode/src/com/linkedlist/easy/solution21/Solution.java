package com.linkedlist.easy.solution21;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val<l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1!=null){
            cur.next = l1;
        }else {
            cur.next = l2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 7, 8};
        int[] num2 = {2, 3, 4};
        ListNode head1 = new ListNode(num1);
        ListNode head2 = new ListNode(num2);
        System.out.println(head1);
        System.out.println(head2);
        System.out.println(new Solution().mergeTwoLists(head1, head2));
    }
}