package com.top100.solution399;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/1 14:48
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //key是某个顶点，value是这个顶点与其相连的顶点以及权重，如a/b=2，(a,(b,2))
        Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> weightGraph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(weightGraph, queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> weightGraph, String first, String second, double value, HashSet<String> visited) {
        if (!weightGraph.containsKey(first) || !weightGraph.containsKey(second) || visited.contains(first)) {
            return -1;
        }
        if (first.equals(second)) {
            return 1;
        }
        visited.add(first);
        ArrayList<AbstractMap.SimpleEntry<String, Double>> entries = weightGraph.get(first);
        for (AbstractMap.SimpleEntry<String, Double> entry : entries) {
            String key = entry.getKey();
            Double entryValue = entry.getValue();
            if (key.equals(second)) {
                return value * entryValue;
            }
            double res = dfs(weightGraph, key, second, value * entryValue, visited);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }

    private Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> weightGraph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            helper(weightGraph, equation, 1, values[i], 0);
            helper(weightGraph, equation, 0, 1 / values[i], 1);
        }
        return weightGraph;
    }

    private void helper(Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> weightGraph, List<String> equation, int i2, double value, int i3) {
        AbstractMap.SimpleEntry<String, Double> entry = new AbstractMap.SimpleEntry<>(equation.get(i2), value);
        if (!weightGraph.containsKey(equation.get(i3))) {
            ArrayList<AbstractMap.SimpleEntry<String, Double>> list = new ArrayList<>();
            list.add(entry);
            weightGraph.put(equation.get(i3), list);
        } else {
            ArrayList<AbstractMap.SimpleEntry<String, Double>> list = weightGraph.get(equation.get(i3));
            if (!list.contains(entry)) {
                list.add(entry);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("b", "c")));
        equations.add(new ArrayList<>(Arrays.asList("a", "d")));

        double[] values = {2.0, 3.0, 4.0};
        Map<String, ArrayList<AbstractMap.SimpleEntry<String, Double>>> map = new Solution().buildGraph(equations, values);
        System.out.println("ha");
    }
}
