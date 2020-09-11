package com.array.easy.solution849;

/**
 * @author LiSheng
 * @date 2020/3/30 20:21
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < seats.length; i++) {
            //找为0的索引
            if (seats[i] == 0) {
                //从这个索引开始往两边找为1的索引
                int left = i;
                int right = i;
                if (left == 0) {
                    //如果左边为空，只需要找右边
                    for (int j = right + 1; j < seats.length; j++) {
                        if (seats[j] == 1) {
                            max = Math.max(max, j);
                            break;
                        }
                    }
                }
                if (right == seats.length - 1) {
                    //如果右边为空，只需要找左边
                    for (int j = left - 1; j >= 0; j--) {
                        if (seats[j] == 1) {
                            max = Math.max(max, right - j);
                            break;
                        }
                    }
                }
                //左右都不为空
                //先找左边
                int leftDis = 0;
                for (int j = left - 1; j >= 0; j--) {
                    if (seats[j] == 1) {
                        leftDis = i - j;
                        break;
                    }
                }
                //再找右边
                int rightDis = 0;
                for (int j = right + 1; j < seats.length; j++) {
                    if (seats[j] == 1) {
                        rightDis = j - i;
                        break;
                    }
                }
                max = Math.max(Math.min(leftDis, rightDis), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] seats = {1, 1, 0, 0,0};
        System.out.println(new Solution().maxDistToClosest(seats));
    }
}
