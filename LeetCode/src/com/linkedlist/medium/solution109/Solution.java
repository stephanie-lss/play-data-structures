package com.linkedlist.medium.solution109;

import com.ListNode;
import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/13 21:56
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return helper(head, 0, size - 1);
    }

    private TreeNode helper(ListNode head, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = r - (r - l) / 2;
        int tmp = m;
        ListNode cur = head;
        while (tmp > 0) {
            cur = cur.next;
            tmp--;
        }
        TreeNode root = new TreeNode(cur.val);
        root.right = helper(head, m + 1, r);
        root.left = helper(head, l, m - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedListToBST(new ListNode(arr)));
    }
}
