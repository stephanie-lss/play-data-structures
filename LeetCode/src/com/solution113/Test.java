package com.solution113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 12:00
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        System.out.print("list:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        res.add(list);
        System.out.println();
        System.out.print("res:");
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        list.set(0,7);
        System.out.println("***");
        System.out.print("list:");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("res:");
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
        }
    }
}
