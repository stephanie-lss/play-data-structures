package com.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] agrs) {
        //hashCode() 和 equals()测试：
        hashCodeAndEquals();
    }

    public static void hashCodeAndEquals() {
        //第一个 Set集合：
        Set<String> set1 = new HashSet<String>();
        String str1 = new String("jiaboyan");
        String str2 = new String("jiaboyan");
        String str3 = "jiaboyan";
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));
        set1.add(str1);
        set1.add(str2);
        set1.add(str3);
        System.out.println("长度：" + set1.size() + ",内容为：" + set1);

        //第二个 Set集合：
        Set<App> set2 = new HashSet<App>();
        App app1 = new App();
        app1.setName("jiaboyan");

        App app2 = new App();
        app2.setName("jiaboyan");

        set2.add(app1);
        set2.add(app2);
        System.out.println("长度：" + set2.size() + ",内容为：" + set2);

        //第三个 Set集合：
        Set<App> set3 = new HashSet<App>();
        App app3 = new App();
        app3.setName("jiaboyan");
        set3.add(app3);
        set3.add(app3);
        System.out.println("长度：" + set3.size() + ",内容为：" + set3);
    }

    private static class App {
        private String str;

        public void setName(String str) {
            this.str = str;
        }
    }
}