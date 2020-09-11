package com.offer.interview22;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/7/7 21:38
 */
public class Solution2 {
    private int K;
    private ListNode ret;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        this.K = k;
        dfs(head);
        return ret;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        if (--K == 0) {
            ret = head;
            return;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution2().getKthFromEnd(head, 5));
    }
}
