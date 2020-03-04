package com.solution328;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/22 23:02
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummyHead = new ListNode(-1);
        ListNode evenDummyHead = new ListNode(-1);
        ListNode pre1 = evenDummyHead;
        ListNode pre2 = oddDummyHead;
        int count = 1;
        while (head != null) {
            if (count % 2 == 0) {
                //偶数
                pre1.next = head;
                head = head.next;
                pre1 = pre1.next;
                pre1.next = null;
            } else {
                //奇数
                pre2.next = head;
                head = head.next;
                pre2 = pre2.next;
                pre2.next = null;
            }
            count++;
        }
        pre2.next = evenDummyHead.next;
        return oddDummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        System.out.println(new Solution().oddEvenList(new ListNode(nums)));
    }
}
