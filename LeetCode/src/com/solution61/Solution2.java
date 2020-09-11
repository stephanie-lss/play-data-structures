package com.solution61;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 11:49
 */
public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;

        }
        cur.next = head;
        int n = length + 1;

        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Solution2().rotateRight(new ListNode(nums), 1978989080));
    }
}
