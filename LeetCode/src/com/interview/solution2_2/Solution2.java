package com.interview.solution2_2;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 10:15
 */
public class Solution2 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- != 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
