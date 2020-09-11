package com.top100.solution399;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/1 14:48
 */
class Solution2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //key是某个顶点，value是这个顶点与其相连的顶点以及权重，如a/b=2，(a,(b,2))
        Map<String, Map<String, Double>> weightGraph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(weightGraph, queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> weightGraph, String first, String second, double value, HashSet<String> visited) {
        if (!weightGraph.containsKey(first) || !weightGraph.containsKey(second) || visited.contains(first)) {
            return -1;
        }
        if (first.equals(second)) {
            return 1;
        }
        visited.add(first);
        Map<String, Double> entries = weightGraph.get(first);
        if (entries.containsKey(second)) {
            return value * entries.get(second);
        } else {
            for (Map.Entry<String, Double> entry : entries.entrySet()) {
                double res = dfs(weightGraph, entry.getKey(), second, value * entry.getValue(), visited);
                if (res != -1) {
                    return res;
                }
            }
        }
        return -1;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> weightGraph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            helper(weightGraph, equation, 1, values[i], 0);
            helper(weightGraph, equation, 0, 1 / values[i], 1);
        }
        return weightGraph;
    }

    private void helper(Map<String, Map<String, Double>> weightGraph, List<String> equation, int i2, double value, int i3) {
        Map<String, Double> map = new HashMap<>();
        if (!weightGraph.containsKey(equation.get(i3))) {
            map.put(equation.get(i2), value);
            weightGraph.put(equation.get(i3), map);
        } else {
            map = weightGraph.get(equation.get(i3));
            map.put(equation.get(i2), value);
        }
    }
}
