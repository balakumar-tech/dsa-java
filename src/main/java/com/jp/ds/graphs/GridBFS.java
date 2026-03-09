package com.jp.ds.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GridBFS {

    public static void main(String[] args) {
        //Input grid: [[1, 1, 0, 0], [0, 0, 1, 1], [1, 0, 1, 1], [1, 0, 0, 0]]
        //Output: [[0, 0], [0, 1], [1, 2], [1, 3], [2, 3], [2, 2], [2, 0], [3, 0]]

        int[][] input1  = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}, {1, 0, 0, 0}};
        System.out.println(breadthFirstTraversal(input1));

        //Input: grid = [[1, 0, 0, 1], [0, 0, 0, 0], [1, 1, 1, 1], [0, 0, 0, 1]]
        //Output: [[0, 0], [0, 3], [2, 0], [2, 1], [2, 2], [2, 3], [3, 3]]
        int[][] input2  = {{1, 0, 0, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}};
        System.out.println(breadthFirstTraversal(input2));
    }

    public static List<List<Integer>> breadthFirstTraversal(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length;
        if(rows == 0) {
            return result;
        }
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {

                if(visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                bfs(grid, i, j, visited, result);
            }
        }
        return result;
    }

    public static void bfs(int[][] grid, int row, int col, boolean[][] visited, List<List<Integer>> result) {

        visited[row][col] = true;
        result.add(List.of(row, col));

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int[][] directions = {{-1, 0}, {0, 1},{1,0},{0, -1}};
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for(int[] arr: directions) {
                int newR = coordinates[0] + arr[0];
                int newC = coordinates[1] + arr[1];
                if(isValidCell(newR, newC, visited, grid)) {
                    visited[newR][newC] = true;
                    result.add(List.of(newR, newC));
                    queue.add(new int[]{newR, newC});
                }
            }
        }


    }

    private static boolean isValidCell(int row, int col, boolean[][] visited, int[][] grid) {

        return row >= 0 && row < grid.length
                && col >=0 && col < grid[0].length
                && !visited[row][col] && grid[row][col] == 1;
    }
}
