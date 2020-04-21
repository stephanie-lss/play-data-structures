package com.linkedlist.medium.solution148;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/16 21:04
 */
class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode cut = head;
        while (fast != null && fast.next != null) {
            cut = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        cut.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        pre.next = left != null ? left : right;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3,5};
        ListNode head = new ListNode(arr);
        System.out.println(new Solution().sortList(head));
    }
}
