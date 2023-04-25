package com.java8.stream.arithmetic.dp;

public class Solution1 {
    public int maxAreaOfIsland(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int island = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    island ++;
                    infect(i, j, N, M, grid);
                }
            }
        }
        return island;
    }

    public void infect(int i, int j, int N, int M, char[][] grid) {
        if (i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == '1') {
            return;
        }

        grid[i][j] = '2';
        infect(i-1, j, N, M, grid);
        infect(i+1, j, N, M, grid);
        infect(i, j-1, N, M, grid);
        infect(i, j+1, N, M, grid);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] grid = {{0,0,'1',0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(solution.maxAreaOfIsland(grid));
    }
}