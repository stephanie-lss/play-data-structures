package com.linkedlist.easy.solution141;

import com.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast.next == null) {
            return false;
        }
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution().hasCycle(head));
    }
}