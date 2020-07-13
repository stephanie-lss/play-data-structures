package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test2 {

    int num = 1;
    static String str = "123";

    private class InnerC {
        private void f() {
            System.out.println(Test2.str);
            System.out.println(num);
            new Test2().fun2();
        }
    }

    public static void staticFun1() {
        Test2 test2 = new Test2();

        System.out.println(Test2.str);
        System.out.println(test2.num);
        test2.fun2();
        System.out.println("staticFun1");
    }

    public void fun2() {
        Test2.staticFun1();
//        Test2 test2 = new Test2();
//        test2.staticFun1();
//        System.out.println("fun2");
    }

    public static void main(String[] args) {
        staticFun1();
    }
}