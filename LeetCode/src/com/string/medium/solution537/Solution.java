package com.string.medium.solution537;

/**
 * @author LiSheng
 * @date 2020/4/13 12:22
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        return (new int[]{Integer.parseInt(a.split("\\+")[0]), Integer.parseInt(a.split("\\+")[1].substring(0, a.split("\\+")[1].length() - 1))}[0] * new int[]{Integer.parseInt(b.split("\\+")[0]), Integer.parseInt(b.split("\\+")[1].substring(0, b.split("\\+")[1].length() - 1))}[0] - new int[]{Integer.parseInt(a.split("\\+")[0]), Integer.parseInt(a.split("\\+")[1].substring(0, a.split("\\+")[1].length() - 1))}[1] * new int[]{Integer.parseInt(b.split("\\+")[0]), Integer.parseInt(b.split("\\+")[1].substring(0, b.split("\\+")[1].length() - 1))}[1]) + "+" + (new int[]{Integer.parseInt(a.split("\\+")[0]), Integer.parseInt(a.split("\\+")[1].substring(0, a.split("\\+")[1].length() - 1))}[0] * new int[]{Integer.parseInt(b.split("\\+")[0]), Integer.parseInt(b.split("\\+")[1].substring(0, b.split("\\+")[1].length() - 1))}[1] + new int[]{Integer.parseInt(a.split("\\+")[0]), Integer.parseInt(a.split("\\+")[1].substring(0, a.split("\\+")[1].length() - 1))}[1] * new int[]{Integer.parseInt(b.split("\\+")[0]), Integer.parseInt(b.split("\\+")[1].substring(0, b.split("\\+")[1].length() - 1))}[0]) + "i";
    }
}
