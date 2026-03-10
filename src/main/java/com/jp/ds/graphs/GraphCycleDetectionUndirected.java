package com.jp.ds.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphCycleDetectionUndirected {

    public static void main(String[] args) {
        //Input: graph = [[1, 2], [0, 4], [0, 3], [2, 4], [1, 3]]
        //Output: true

        List<List<Integer>> input1 = List.of(List.of(1, 2), List.of(0, 4),
                List.of(0, 3), List.of(2, 4), List.of(1, 3));
        System.out.println(cycleDetection(input1));

        //Input: graph = [[1], [0, 2], [1]]
        //Output: false

        List<List<Integer>> input2 = List.of(List.of(1), List.of(0, 2),
                List.of(1));
        System.out.println(cycleDetection(input2));
    }

    public static boolean cycleDetection(List<List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        int N = graph.size();
        for(int i = 0; i < N; i++) {
            if(!visited.contains(i)) {
                if(hasCycle(i, -1, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(int node, int parent,
                                    List<List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for(int nbr: graph.get(node)) {
            if(!visited.contains(nbr)) {
                if(hasCycle(nbr, node, graph, visited)) {
                    return true;
                }
            } else if(nbr !=  parent) {
                return true;
            }
        }
        return false;
    }
}
