package com.solution19;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 8:42
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        for (int i = 0; i <= n; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        //删除倒数第n个节点
        p.next = p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution().removeNthFromEnd(new ListNode(nums), 2));
    }

}
