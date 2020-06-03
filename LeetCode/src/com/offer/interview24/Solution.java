package com.offer.interview24;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 14:47
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
}
