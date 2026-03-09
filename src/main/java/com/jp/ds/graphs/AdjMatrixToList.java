package com.jp.ds.graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixToList {

    public static void main(String[] args) {

        int[][] adjMatrix = {{0, 1, 0, 1, 0},
                            {0, 0, 0, 0, 1},
                            {0, 0, 0, 0, 1},
                            {0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 0}};

        System.out.println(adjacencyMatrixToAdjacencyList(adjMatrix));
    }

    public static List<List<Integer>> adjacencyMatrixToAdjacencyList(
            int[][] adjMatrix) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n= adjMatrix.length;
        for(int i=0; i < n; i++) {
            adjList.add(new ArrayList<>());
            for(int j=0; j < n; j++) {
                if(adjMatrix[i][j] == 1)
                    adjList.get(i).add(j);
            }
        }
        return adjList;
    }
}
