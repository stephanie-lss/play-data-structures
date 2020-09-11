package com.offer.interview06;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/12 17:22
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        int size = 0;
        while (cur != null) {
            size++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}