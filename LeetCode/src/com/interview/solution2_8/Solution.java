package com.interview.solution2_8;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/25 13:15
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
