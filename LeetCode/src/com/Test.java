package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('a');
        list.add('b');
        list.add('b');
        list.remove((Character) ('a'));
        for (Character character : list) {
            System.out.println(character);
        }
    }

}