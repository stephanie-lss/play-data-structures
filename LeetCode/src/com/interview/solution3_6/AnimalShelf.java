package com.interview.solution3_6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/26 9:51
 */
class AnimalShelf {

    private Deque<int[]> cat;
    private Deque<int[]> dog;
    private int age = 0;

    public AnimalShelf() {
        this.cat = new LinkedList<>();
        this.dog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            cat.addLast(new int[]{animal[0], age});
        } else {
            dog.addLast(new int[]{animal[0], age});
        }
        age++;
    }

    public int[] dequeueAny() {
        if (cat.isEmpty() && dog.isEmpty()) {
            return new int[]{-1, -1};
        } else if (cat.isEmpty()) {
            return new int[]{dog.removeFirst()[0], 1};
        } else if (dog.isEmpty()) {
            return new int[]{cat.removeFirst()[0], 0};
        } else {
            return dog.getFirst()[1] < cat.getFirst()[1] ? new int[]{dog.removeFirst()[0], 1} : new int[]{cat.removeFirst()[0], 0};
        }
    }

    public int[] dequeueDog() {
        if (dog.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{dog.removeFirst()[0], 1};
    }

    public int[] dequeueCat() {
        if (cat.isEmpty()) {
            return new int[]{-1, -1};
        }
        return new int[]{cat.removeFirst()[0], 0};
    }
}