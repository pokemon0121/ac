package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrappingRainWaterII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0] == null || heightMap[0].length < 3) {
            return 0;
        }
        int water = 0;
        int row = heightMap.length, col = heightMap[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Cell> minHeap = new PriorityQueue<>(Comparator.comparing(c -> c.getHeight()));
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            minHeap.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            visited[i][col - 1] = true;
        }
        for (int i = 0; i < col; i++) {
            minHeap.offer(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
            minHeap.offer(new Cell(row - 1, i, heightMap[row - 1][i]));
            visited[row - 1][i] = true;
        }
        while (!minHeap.isEmpty()) {
            Cell cur = minHeap.poll();
            for (int[] dir : dirs) {
                int nextI = cur.i + dir[0];
                int nextJ = cur.j + dir[1];
                if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    water += Math.max(0, cur.h - heightMap[nextI][nextJ]);
                    minHeap.offer(new Cell(nextI, nextJ, Math.max(cur.h, heightMap[nextI][nextJ])));
                }
            }
        }
        return water;
    }

    public class Cell {
        public int i;
        public int j;
        public int h;

        public Cell(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }

        public int getHeight() {
            return h;
        }
    }
}
