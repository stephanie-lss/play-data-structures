package com.linkedlist.easy.solution206;

import com.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution().reverseList(head));
    }
}