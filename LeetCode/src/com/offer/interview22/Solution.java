package com.offer.interview22;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 10:36
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode tail = head;
        while (k-- != 0) {
            tail = tail.next;
        }
        while (tail != null) {
            pre = pre.next;
            tail = tail.next;
        }
        return pre;
    }
}
