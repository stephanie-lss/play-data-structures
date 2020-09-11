package com.solution92;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/7/15 10:09
 */
public class Solution2 {
    private ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListNode(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseListNode(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode ret = reverseListNode(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return ret;
    }
}
