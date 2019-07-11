package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 's');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder path, char dir) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
            return;
        }
        path.append(dir);
        grid[x][y] = 0;
        dfs(grid, x + 1, y, path, 'a');
        dfs(grid, x, y + 1, path, 'b');
        dfs(grid, x - 1, y, path, 'c');
        dfs(grid, x, y - 1, path, 'd');
        path.append('e');
    }
}
