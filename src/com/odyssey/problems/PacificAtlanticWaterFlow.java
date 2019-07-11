package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class PacificAtlanticWaterFlow implements IProblem {

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> pos = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return pos;
        }
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            q.offer(i * cols);
            pacific[i][0] = true;
            visited.add(i * cols);
        }
        for (int i = 0; i < cols; i++) {
            q.offer(i);
            pacific[0][i] = true;
            visited.add(i);
        }
        bfs(matrix, pacific, q, visited);
        visited.clear();
        for (int i = 0; i < rows; i++) {
            q.offer(i * cols + cols - 1);
            atlantic[i][cols - 1] = true;
            visited.add(i * cols + cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            q.offer((rows - 1) * cols + i);
            atlantic[rows - 1][i] = true;
            visited.add((rows - 1) * cols + i);
        }
        bfs(matrix, atlantic, q, visited);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    // update distance from 0s
                    pos.add(new int[]{i, j});
                }
            }
        }
        return pos;
    }

    private void bfs(int[][] matrix, boolean[][] ocean, Queue<Integer> q, Set<Integer> visited) {
        int rows = matrix.length, cols = matrix[0].length;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curX = cur / cols, curY = cur % cols;
            ocean[curX][curY] = true;
            visited.add(curX * cols + curY);
            for (int[] dir : dirs) {
                int nextX = curX + dir[0], nextY = curY + dir[1];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[curX][curY] <= matrix[nextX][nextY] && visited.add(nextX * cols + nextY)) {
                    q.offer(nextX * cols + nextY);
                }
            }
        }
    }
}
