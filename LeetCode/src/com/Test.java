package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        String str = "9";
        System.out.println(str.compareTo("999") <= 0);
        System.out.println(Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 25);
    }
}