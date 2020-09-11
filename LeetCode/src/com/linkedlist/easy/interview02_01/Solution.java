package com.linkedlist.easy.interview02_01;

import com.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiSheng
 * @date 2020/4/6 11:46
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        ListNode head = new ListNode(arr);
        System.out.println(new Solution().removeDuplicateNodes(head));
    }
}