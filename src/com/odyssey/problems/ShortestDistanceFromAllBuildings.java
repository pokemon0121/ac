package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings implements IProblem {

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length, cols = grid[0].length;
        int[][] dis = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, dis, i, j);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && dis[i][j] != 0) {
                    shortest = Math.min(shortest, dis[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private void bfs(int[][] grid, int[][] dis, int x, int y) {
        int rows = grid.length, cols = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(x * cols + y);
        int d = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int curX = cur / cols, curY = cur % cols;
                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && grid[nextX][nextY] == 0 && visited.add(nextX * cols + nextY)) {
                        dis[nextX][nextY] += d;
                        q.offer(nextX * cols + nextY);
                    }
                }
            }
            d++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited.contains(i * cols + j)) {
                    grid[i][j] = 2;
                }
            }
        }
    }
}
