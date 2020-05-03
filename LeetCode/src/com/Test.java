package com;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        int i = linkedList.indexOf(2);
        linkedList.subList(i + 1, linkedList.size());
    }

}