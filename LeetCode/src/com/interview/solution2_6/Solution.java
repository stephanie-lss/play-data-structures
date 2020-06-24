package com.interview.solution2_6;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 11:02
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //链表翻转
            ListNode next = slow.next;
            slow.next = cur;
            cur = slow;
            slow = next;
        }
        slow = fast != null ? slow.next : slow;
        while (slow != null) {
            if (slow.val == cur.val) {
                slow = slow.next;
                cur = cur.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 2, 1};
        ListNode head = new ListNode(num);
        System.out.println(new Solution().isPalindrome(head));
    }
}