package com.tree.easy.solution671;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/4/7 12:48
 */
public class Solution2 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int min = root.val;
        int num1 = root.left.val;
        int num2 = root.right.val;
        if (num1 != min && num2 != min) {
            return Math.min(num1, num2);
        }
        if (num1 == min) {
            num1 = findSecondMinimumValue(root.left);
        }
        if (num2 == min) {
            num2 = findSecondMinimumValue(root.right);
        }
        return num1 == -1 ? num2 : (num2 == -1 ? num1 : Math.min(num1, num2));
    }
}