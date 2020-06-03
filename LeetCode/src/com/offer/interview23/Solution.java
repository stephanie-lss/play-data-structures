package com.offer.interview23;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 15:23
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int sLen = 0;
        while (true) {
            if (fast== null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            sLen++;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        fast = head;
        while (sLen-- != 0) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
