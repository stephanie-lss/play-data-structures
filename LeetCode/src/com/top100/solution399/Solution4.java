package com.top100.solution399;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/5/1 20:38
 */
class Solution4 {
    class Node {
        double value;
        Node parent;

        Node() {
            this.parent = this;
        }
    }

    public Node findParent(Node node) {
        while (node.parent != node) {
            node = node.parent;
        }
        return node;
    }

    public void union(Node n1, Node n2, double val, Map<String, Node> map) {
        Node p1 = findParent(n1);
        Node p2 = findParent(n2);
        double ratio = val * n2.value / n1.value;  //两个分开的p1和p2所代表的图  如果合并p2和p1 p1全体应该放大ratio倍
        for (Node n : map.values()) {
            if (findParent(n) == p1) {
                n.value = ratio * n.value;
            }
        }
        p2.parent = p1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //1.使用并查集  并查集两个操作 find 和union
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            if (!map.containsKey(first) && !map.containsKey(second)) {
                Node n1 = new Node();
                Node n2 = new Node();
                n1.value = values[i];
                n2.value = 1;
                n2.parent = n1;
                map.put(first, n1);
                map.put(second, n2);
            } else if (!map.containsKey(first)) {
                Node n = new Node();
                n.value = map.get(second).value * values[i];
                n.parent = map.get(second);
                map.put(first, n);
            } else if (!map.containsKey(second)) {
                Node n = new Node();
                n.value = map.get(first).value / values[i];
                n.parent = map.get(first);
                map.put(second, n);
            } else {
                union(map.get(first), map.get(second), values[i], map);
            }
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            if (map.containsKey(first) && map.containsKey(second) && findParent(map.get(first)) == findParent(map.get(second))) {
                res[i] = map.get(first).value / map.get(second).value;
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("a", "c")));
        equations.add(new ArrayList<>(Arrays.asList("b", "d")));
        equations.add(new ArrayList<>(Arrays.asList("a", "b")));
        equations.add(new ArrayList<>(Arrays.asList("a", "d")));
        double[] values = {2.0, 3.0, 4.0, 5.0};
        List<List<String>> querys = new ArrayList<>();
        querys.add(new ArrayList<>(Arrays.asList("b", "c")));
        System.out.println(new Solution4().calcEquation(equations, values, querys));
    }

    /*public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //floyd算法
        //为了能够简化，将equations中每个字母都映射到数字
        HashMap<String,Integer> map=new HashMap<>();
        int count=1;
        for(int i=0;i<equations.size();i++){
            String first=equations.get(i).get(0);
            String second=equations.get(i).get(1);
            if(!map.containsKey(first)){
                map.put(first,count++);
            }
            if(!map.containsKey(second)){
                map.put(second,count++);
            }
        }
        //图的初始化构造
        double [][]graph=new double[count][count];
        for(int i=0;i<equations.size();i++){
            int firstIndex=map.get(equations.get(i).get(0));
            int secondIndex=map.get(equations.get(i).get(1));
            graph[firstIndex][secondIndex]=values[i];
            graph[secondIndex][firstIndex]=1/values[i];
        }
        //更新图，计算距离
        for(int i=1;i<count;i++){
            for(int j=1;j<count;j++){
                for(int k=1;k<count;k++){
                    if(graph[i][j]==0&&graph[i][k]!=0&&graph[k][j]!=0){
                        graph[i][j]=graph[i][k]*graph[k][j];
                        break;
                    }
                }
            }
        }
        //结果计算
        double []res=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String first=queries.get(i).get(0);
            String second=queries.get(i).get(1);
            if(map.containsKey(first)&&map.containsKey(second)&&graph[map.get(first)][map.get(second)]!=0){
                res[i]=graph[map.get(first)][map.get(second)];
            }else{
                res[i]=-1.0;
            }
        }
        return res;
    }*/
}
