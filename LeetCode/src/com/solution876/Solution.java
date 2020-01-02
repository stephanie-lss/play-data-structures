package com.solution876;

import com.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur!=null){
            cur = cur.next;
            count++;
        }
        cur = head;
        for (int i = 0; i < count/2; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode head = new ListNode(nums);
        ListNode newHead = new Solution().middleNode(head);
        System.out.println(newHead);
    }
}