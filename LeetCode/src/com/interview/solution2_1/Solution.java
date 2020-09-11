package com.interview.solution2_1;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 9:49
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = cur;
            ListNode next = cur.next;
            while (next != null) {
                if (next.val == cur.val) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 1};
        ListNode head = new ListNode(nums);
        new Solution().removeDuplicateNodes(head);
    }
}