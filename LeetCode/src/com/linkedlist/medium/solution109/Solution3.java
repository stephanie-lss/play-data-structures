package com.linkedlist.medium.solution109;

import com.ListNode;
import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/13 21:56
 */
public class Solution3 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        System.out.println(new Solution3().sortedListToBST(new ListNode(arr)));
    }
}
