package com.interview.solution5_8;

/**
 * @author LiSheng
 * @date 2020/6/29 15:14
 */
class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int[] line = new int[w];
        for (int i = x1; i <= x2; i++) {
            line[i] = 1;
        }
        for (int i = 0; i < length; i++) {
            boolean sign = true;
            if (line[i * 32] == 1) {
                sign = false;
            }
            int tmp = 0;
            for (int j = i * 32 + 1; j < (i + 1) * 32; j++) {
                if (sign) {
                    //如果第一位是0,十进制为正数
                    tmp = tmp * 2 + line[j];
                } else {
                    if (line[j] == 0) {
                        tmp = tmp * 2 + 1;
                    }
                }
            }
            if (sign) {
                res[i] = tmp;
            } else {
                res[i] = -(tmp + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new Solution().drawLine(15, 96, 81, 95, 1);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}