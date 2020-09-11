package com.offer.interview24;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/3 14:54
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        return dfs(head);
    }

    private ListNode dfs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = dfs(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution2().reverseList(head));
    }
}
