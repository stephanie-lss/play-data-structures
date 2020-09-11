package com.interview.solution2_4;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 10:24
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        if (cur == null) {
            return head;
        }
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode del = cur.next;
                cur.next = cur.next.next;
                del.next = pre.next;
                pre.next = del;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4};
        ListNode node = new ListNode(nums);
        ListNode partition = new Solution().partition(node, 2);
        System.out.println(partition);
    }
}