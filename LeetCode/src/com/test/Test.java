package com.test;

/**
 * @author LiSheng
 * @date 2020/7/7 19:16
 */
public class Test extends Thread {
    String name;

    public static void main(String[] args) {
        Test test = new Test();
        test.execte();
    }

    Test() {
    }

    Test(String name) {
        this.name = name;
    }

    public String getThreadName() {
        return name;
    }

    public void execte() {
        Test first = new Test("one");
        first.start();
        Test second = new Test("two");
        second.start();
    }

    public void start() {
        for (int i = 0; i < 2; i++) {
            System.out.println(this.getThreadName() + i);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
