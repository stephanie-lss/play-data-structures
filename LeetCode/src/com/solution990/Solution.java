package com.solution990;

import java.util.HashMap;

/**
 * @author LiSheng
 * @date 2020/6/8 8:57
 */
public class Solution {
    private class UnionFind {
        private HashMap<Character, Character> parent;
        private HashMap<Character, Integer> depth;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.depth = new HashMap<>();
        }

        public void unionElement(char p, char q) {
            char pRoot = findRoot(p);
            char qRoot = findRoot(q);
            if (depth.get(pRoot) > depth.get(qRoot)) {
                parent.put(qRoot, pRoot);
            } else if (depth.get(pRoot) < depth.get(qRoot)) {
                parent.put(pRoot, qRoot);
            } else {
                parent.put(pRoot, qRoot);
                depth.put(qRoot, depth.get(qRoot) + 1);
            }
        }

        public char findRoot(char p) {
            if (p != parent.get(p)) {
                parent.put(p, findRoot(parent.get(p)));
            }
            return parent.get(p);
        }

        public boolean isConnect(char p, char q) {
            return findRoot(p) == findRoot(q);
        }
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            unionFind.parent.put(x, x);
            unionFind.parent.put(y, y);
            unionFind.depth.put(x, 1);
            unionFind.depth.put(y, 1);
        }

        for (String equation : equations) {
            if (equation.charAt(1) == equation.charAt(2)) {
                unionFind.unionElement(equation.charAt(0), equation.charAt(3));
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) != equation.charAt(2)) {
                if (unionFind.isConnect(equation.charAt(0), equation.charAt(3))) {
                    return false;
                }
            }
        }
        return true;
    }
}
