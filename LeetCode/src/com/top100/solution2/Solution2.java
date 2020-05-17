package com.top100.solution2;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/7 22:19
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
