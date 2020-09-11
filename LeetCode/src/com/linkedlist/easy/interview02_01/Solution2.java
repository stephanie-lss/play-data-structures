package com.linkedlist.easy.interview02_01;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 11:46
 */
class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null) {
                if (pre.next.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2};
        ListNode head = new ListNode(arr);
        System.out.println(new Solution2().removeDuplicateNodes(head));
    }
}