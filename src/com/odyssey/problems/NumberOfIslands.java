package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class NumberOfIslands implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private int ret = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return ret;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
    }
}
