package com.solution24;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/23 19:13
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if (dummyHead.next == null || dummyHead.next.next == null) {
            return head;
        }
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().swapPairs(new ListNode(nums)));
    }
}
