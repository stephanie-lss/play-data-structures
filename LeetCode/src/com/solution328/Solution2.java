package com.solution328;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/22 23:31
 */
public class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = oddHead.next;
        ListNode evenTail = evenHead;
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        System.out.println(new Solution().oddEvenList(new ListNode(nums)));
    }
}
