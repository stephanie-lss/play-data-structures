package com.offer.interview54;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/6/13 12:24
 */
public class Solution4 {
    private int res;
    private int K;

    public int kthLargest(TreeNode root, int k) {
        K = k;
        reversInOrder(root);
        return res;
    }

    private void reversInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reversInOrder(root.right);
        if (--K == 0) {
            res = root.val;
            return;
        }
        reversInOrder(root.left);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution4().kthLargest(root, 3));
    }
}
