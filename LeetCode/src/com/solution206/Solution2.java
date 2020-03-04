package com.solution206;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/20 11:01
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }
}