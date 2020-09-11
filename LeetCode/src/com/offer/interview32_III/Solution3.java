package com.offer.interview32_III;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/4 11:00
 */
public class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        boolean isReverse = true;
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                tmp.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            isReverse = !isReverse;
            if (isReverse) {
                Collections.reverse(tmp);
            }
            ret.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = ConstructTree.constructTree(nums);
        List<List<Integer>> lists = new Solution3().levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
