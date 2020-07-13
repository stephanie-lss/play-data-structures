package com.test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] agrs){
        customComparatorSort();
    }

    //自定义比较器：升序
    public static void customComparatorSort(){
        TreeSet<App> treeSet = new TreeSet<>(new AppComparator());
        
        //排序对象：
        App app1 = new App("hello",10);
        App app2 = new App("world",20);
        App app3 = new App("my",15);
        App app4 = new App("name",25);
        
        //添加到集合：
        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);
        System.out.println("TreeSet集合顺序为："+treeSet);
    }
}
//自定义App类的比较器：
class AppComparator implements Comparator<App> {

    //比较方法：先比较年龄，年龄若相同在比较名字长度；
    @Override
    public int compare(App app1, App app2) {
        int num = app1.getName().length() - app2.getName().length();
        return num == 0 ? app1.getAge() - app2.getAge() : num;
    }
}

class App{

    private String name;

    private Integer age;

    public App(){}

    public App(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}