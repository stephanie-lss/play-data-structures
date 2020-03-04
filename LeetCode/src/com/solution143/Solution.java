package com.solution143;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 10:49
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        ListNode slow = head.next;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转后部分的链表
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //此时前一链表为slow前并去除第一个节点的链表，后一部分为slow后并逆转了的链表
        ListNode newHead = head;
        ListNode oldHead = head.next;
        head.next = null;

        //依次从逆转链表，和oldHead中拿出一个节点并拼接到newHead上，
        while (pre != null) {
            ListNode newNext = pre.next;
            ListNode oldNext = oldHead.next;

            pre.next = oldHead;
            head.next = pre;
            oldHead.next = null;
            head = pre.next;

            pre = newNext;
            oldHead = oldNext;
        }
        //当链表长度为偶数个节点时，前一部分会比逆转的链表多一个节点，此时把剩余的一个节点拼接到新链表的尾部
        if (oldHead != null) {
            head.next = oldHead;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4,5};
        new Solution().reorderList(new ListNode(nums));
    }
}
