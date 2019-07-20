package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.PriorityQueue;

public class LongestIncreasingPathInAMatrix implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        return dfs(matrix);
    }

    private int dfs(int[][] matrix) {
        int ret = 0;
        Integer[][] mem = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ret = Math.max(ret, dfs(matrix, i, j, mem));
            }
        }
        return ret;
    }

    private int dfs(int[][] m, int x, int y, Integer[][] mem) {
        int row = m.length, col = m[0].length;
        if (mem[x][y] != null) {
            return mem[x][y];
        }
        int ret = 0;
        for (int[] dir : dirs) {
            int nextX = x + dir[0], nextY = y + dir[1];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && m[nextX][nextY] > m[x][y]) {
                ret = Math.max(ret, dfs(m, nextX, nextY, mem));
            }
        }
        return mem[x][y] = ret + 1;
    }
}
