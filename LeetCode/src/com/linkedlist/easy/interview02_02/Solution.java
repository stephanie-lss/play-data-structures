package com.linkedlist.easy.interview02_02;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 14:22
 */
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
