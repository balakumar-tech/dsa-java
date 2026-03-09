package com.jp.ds.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GridDFS {

    public static void main(String[] args) {
        //Input grid: [[1, 1, 0, 0], [0, 0, 1, 1], [1, 0, 1, 1], [1, 0, 0, 0]]
        //Output: [[0, 0], [0, 1], [1, 2], [1, 3], [2, 3], [2, 2], [2, 0], [3, 0]]

        int[][] intput1  = {{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}, {1, 0, 0, 0}};
        System.out.println(depthFirstTraversal(intput1));

        //Input: grid = [[1, 0, 0, 1], [0, 0, 0, 0], [1, 1, 1, 1], [0, 0, 0, 1]]
        //Output: [[0, 0], [0, 3], [2, 0], [2, 1], [2, 2], [2, 3], [3, 3]]
        int[][] intput2  = {{1, 0, 0, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}};
        System.out.println(depthFirstTraversal(intput2));
    }

    public static List<List<Integer>> depthFirstTraversal(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = grid.length;
        if(rows == 0) {
            return result;
        }
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                if(visited[i][j] || grid[i][j] == 0) {
                    continue;
                }
                dfs(grid, visited, i, j, result);
            }
        }
        return result;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col, List<List<Integer>> result) {
        visited[row][col] = true;
        result.add(List.of(row, col));

        //Up
        if( row - 1 >= 0 && grid[row - 1][col] == 1 && !visited[row-1][col]) {
            dfs(grid, visited, row - 1, col, result);
        }

        //Down
        if( row + 1 < grid.length && grid[row + 1][col] == 1 && !visited[row+1][col]) {
            dfs(grid, visited, row + 1, col, result);
        }

        //Left
        if(col - 1 >= 0 && grid[row][col-1] == 1 && !visited[row][col-1]) {
            dfs(grid, visited, row, col-1, result);
        }

        //Right
        if(col + 1 < grid[0].length && grid[row][col+1] == 1 && !visited[row][col+1]) {
            dfs(grid, visited, row, col+1, result);
        }
    }
}
