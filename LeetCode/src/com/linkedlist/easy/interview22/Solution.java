package com.linkedlist.easy.interview22;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 14:03
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        n -= k;
        while (n-- > 0) {
            head = head.next;
        }
        return head;
    }
}
