package com.linkedlist.medium.solution147;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/17 19:32
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            ListNode d = dummyHead;
            while (d.next != cur) {
                if (d.next.val < cur.val) {
                    d = d.next;
                } else {
                    ListNode next = d.next;
                    //删除cur节点
                    pre.next = pre.next.next;
                    //插进cur节点
                    d.next = cur;
                    cur.next = next;
                    cur = pre.next;
                    break;
                }
            }
            if (d.next == cur) {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 5, 2};
        ListNode head = new ListNode(arr);
        System.out.println(new Solution().insertionSortList(head));
    }
}
