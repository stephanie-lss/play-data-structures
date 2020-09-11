package com.offer.interview54;

import com.TreeNode;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/5/12 19:16
 */
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return pq.peek();
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        if (pq.size() == k) {
            pq.remove();
        }
        pq.offer(root.val);
        inOrder(root.right, k);
    }
}