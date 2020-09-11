package com.linkedlist.hard.solution25;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/16 10:55
 */
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //递归终止条件，当head为null时中止递归
        if (head == null) {
            return null;
        }
        //根据k寻找待翻转链表的尾
        ListNode end = head;
        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }
        //保存好下次翻转的链表的头
        ListNode nextListNode = end.next;
        //翻转[start , end]范围中的链表，并返回头节点
        ListNode newHead = reverseListNode(head, end);
        //此时head已经变成了链表的尾节点
        //本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点，递归实现
        head.next = reverseKGroup(nextListNode, k);
        return newHead;
    }

    private ListNode reverseListNode(ListNode start, ListNode end) {
        ListNode tmp = null;
        while (tmp != end) {
            ListNode next = start.next;
            start.next = tmp;
            tmp = start;
            start = next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution2().reverseKGroup(head, 3));
    }
}