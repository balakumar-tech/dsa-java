package com.jp.ds.graphs;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        //Input: graph = [[1, 2], [4], [3], [0], [2, 3]]
        // Output: [0, 1, 2, 4, 3]
        List<List<Integer>> graph = List.of(List.of(1 ,2), List.of(4),
                List.of(3), List.of(0), List.of(2, 3));
        System.out.println(breadthFirstTraversal(graph));


        //Input: graph = [[4], [0, 3], [0, 4], [2, 4], [1]]
        //Output: [0, 4, 1, 3, 2]
        System.out.println(breadthFirstTraversal(List.of(List.of(4), List.of(0, 3),
                List.of(0, 4), List.of(2, 4), List.of(1))));
    }

    public static List<Integer> breadthFirstTraversal(List<List<Integer>> graph) {

        int N = graph.size();
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i < N; i++) {
            if(!visited.contains(i)) {
                bfs(graph, i, visited, result);
            }
        }

        return result;
    }

    private static void bfs(List<List<Integer>> graph, int source, Set<Integer> visited, List<Integer> result) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for(int nbr: graph.get(node)) {
                if(!visited.contains(nbr)) {
                    queue.offer(nbr);
                    visited.add(nbr);
                }
            }
        }
    }
}
