package com.jp.ds.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {

    public static void main(String[] args) {
        //Input: graph = [[1], [4], [3], [0], [2, 3]]
        // Output: [0, 1, 4, 2, 3]
        List<List<Integer>> graph = List.of(List.of(1), List.of(4),
                List.of(3), List.of(0), List.of(2, 3));
        System.out.println(depthFirstTraversal(graph));


        //Input: graph = [[4], [0, 3], [0, 4], [2, 4], [1]]
        //Output: [0, 4, 1, 3, 2]
        System.out.println(depthFirstTraversal(List.of(List.of(4), List.of(0, 3),
                List.of(0, 4), List.of(2, 4), List.of(1))));
    }


    public static List<Integer> depthFirstTraversal(List<List<Integer>> graph) {

        int N = graph.size();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i < N; i++) {
            if(!visited.contains(i)) {
                dfs(graph, i, visited, result);
            }
        }
        return result;
    }

    private static void dfs(List<List<Integer>> graph, int node,
                            Set<Integer> visited, List<Integer> result) {

        visited.add(node);
        result.add(node);
        for(int nbr: graph.get(node)) {
            if(!visited.contains(nbr)) {
                dfs(graph, nbr, visited, result);
            }
        }
    }
}
