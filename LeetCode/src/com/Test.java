package com;

public class Test {

    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s4 = s1.intern();
        String s2 = "计算机";
        String s3 = s1.intern();
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 String 对象一个是常量池中的 String 对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象

    }
}
