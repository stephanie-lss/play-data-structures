package com.linkedlist.medium.solution109;

import com.ListNode;
import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/13 21:56
 */
public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    private TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        if (head == slow) {
            return root;
        }
        root.right = helper(slow.next);
        root.left = helper(head);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        System.out.println(new Solution2().sortedListToBST(new ListNode(arr)));
    }
}
