package com.solution61;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 11:49
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode tmpNode = head;
        while (tmpNode != null) {
            length++;
            tmpNode = tmpNode.next;
        }
        k = k % length;
        for (int i = 0; i < k; i++) {
            ListNode cur = head;

            while (cur.next.next != null) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            next.next = head;
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(new Solution().rotateRight(new ListNode(nums), 1978989080));
    }
}
