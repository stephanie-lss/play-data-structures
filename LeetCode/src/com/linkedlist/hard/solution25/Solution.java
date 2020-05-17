package com.linkedlist.hard.solution25;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/16 8:50
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //上次翻转后的链表的尾节点
        ListNode connect = null;
        //本次待翻转链表的头，也是本次翻转完成后的新链表的尾节点
        ListNode start = head;
        while (start != null) {
            //根据k寻找待翻转链表的尾
            int count = 0;
            ListNode end = start;
            while (++count != k) {
                end = end.next;
                if (end == null) {
                    return head;
                }
            }
            //保存好下次翻转的链表的头
            ListNode nextListNode = end.next;
            //翻转start-end中的链表，并返回头节点
            ListNode newHead = reverseListNode(start, end);
            if (connect != null) {
                //将已翻转后的链表的尾节点连接上下次翻转的链表的头，也就是将翻转后的链表接到总链表上去
                connect.next = newHead;
            } else {
                //如果connect为空，此时该节点就为整个脸比埃的新头节点
                head = newHead;
            }
            //本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点
            start.next = nextListNode;
            //保存上一次翻转的链表的尾结点，以便连接上本次翻转链表的头节点
            connect = start;
            //准备进行新一轮的链表反转
            start = nextListNode;
        }
        return head;
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
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution().reverseKGroup(head, 2));
    }
}