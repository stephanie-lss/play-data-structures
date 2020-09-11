package com.offer.interview54;

import com.TreeNode;
import com.tree.ConstructTree;

/**
 * @author LiSheng
 * @date 2020/5/12 19:16
 */
class Solution2 {
    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root != null) {
            kthLargest(root.right, k);
            if (++count == k) {
                res = root.val;
                return root.val;
            }
            kthLargest(root.left, k);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution2().kthLargest(root, 3));
    }
}