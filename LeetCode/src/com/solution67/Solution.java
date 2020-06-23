package com.solution67;

/**
 * @author LiSheng
 * @date 2020/6/23 8:38
 */
class Solution {
    public String addBinary(String a, String b) {
        int rightA = a.length() - 1, rightB = b.length() - 1;
        int mut = 0;
        StringBuilder sb = new StringBuilder();
        while (rightA >= 0 && rightB >= 0) {
            char c = a.charAt(rightA--);
            char d = b.charAt(rightB--);
            int r = (c - '0') ^ (d - '0') ^ mut;
            sb.insert(0, r);
            if (c == '1' && d == '1' || c == '1' && mut == 1 || d == '1' && mut == 1) {
                mut = 1;
            } else {
                mut = 0;
            }
        }
        while (rightA >= 0) {
            int r = (a.charAt(rightA) - '0') ^ mut;
            if (a.charAt(rightA--) == '0' || mut == 0) {
                mut = 0;
            }
            sb.insert(0, r);
        }
        while (rightB >= 0) {
            int r = (b.charAt(rightB) - '0') ^ mut;
            if (b.charAt(rightB--) == '0' || mut == 0) {
                mut = 0;
            }
            sb.insert(0, r);
        }
        return mut == 0 ? sb.toString() : sb.insert(0, 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("101111", "10"));
    }
}