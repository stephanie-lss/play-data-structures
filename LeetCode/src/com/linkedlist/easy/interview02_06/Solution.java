package com.linkedlist.easy.interview02_06;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 13:17
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode newNode = null;
        while (fast.next != null && fast.next.next != null) {
            //慢指针前进的过程中还需要反转链表
            fast = fast.next.next;
            ListNode nextNode = slow.next;
            slow.next = newNode;
            newNode = slow;
            slow = nextNode;
        }
        if (fast.next == null) {
            //链表为奇数个
            ListNode newHead = slow.next;
            while (newHead != null && newNode != null) {
                if (newHead.val != newNode.val) {
                    return false;
                }
                newHead = newHead.next;
                newNode = newNode.next;
            }
        } else {
            //链表为偶数个
            ListNode newHead = slow.next;
            slow.next = newNode;
            while (slow != null && newHead != null) {
                if (slow.val != newHead.val) {
                    return false;
                }
                slow = slow.next;
                newHead = newHead.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] head = {1};
        System.out.println(new Solution().isPalindrome(new ListNode(head)));
    }
}
