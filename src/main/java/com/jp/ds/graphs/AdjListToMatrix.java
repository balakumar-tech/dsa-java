package com.jp.ds.graphs;

import java.util.Arrays;
import java.util.List;

public class AdjListToMatrix {

    public static void main(String[] args) {
        //Input - [[1,3],[4],[4],[2],[3]]
        //Output - [[0, 1, 0, 1, 0], [0, 0, 0, 0, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 0], [0, 0, 0, 1, 0]]
        List<List<Integer>> input1 = List.of(List.of(1,3), List.of(4),
                                                List.of(4), List.of(2), List.of(3));

        System.out.println(Arrays.deepToString(adjacencyListToAdjacencyMatrix(input1)));

        List<List<Integer>> input2 = List.of(List.of(4), List.of(0,3), List.of(0,4),
                                                List.of(2,4), List.of(1));
        //Input - [[4], [0, 3], [0, 4], [2, 4], [1]]
        //Output - [[0, 0, 0, 0, 1], [1, 0, 0, 1, 0], [1, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 1, 0, 0, 0]]

        System.out.println(Arrays.deepToString(adjacencyListToAdjacencyMatrix(input2)));
    }

    public static int[][] adjacencyListToAdjacencyMatrix(
                        List<List<Integer>> adjList) {
        int n = adjList.size();
        int[][] answer = new int[n][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j < adjList.get(i).size(); j++) {
                answer[i][adjList.get(i).get(j)] = 1;
            }
        }
        return answer;
    }
}
