package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix implements IProblem {

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int rows = matrix.length, cols = matrix[0].length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    // update distance from 0s
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // update distance from 0s
                    q.offer(i * cols + j);
                }
            }
        }
        int dis = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int curX = cur / cols, curY = cur % cols;
                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[nextX][nextY] == Integer.MAX_VALUE) {
                        matrix[nextX][nextY] = dis;
                        q.offer(nextX * cols + nextY);
                    }
                }
            }
            dis++;
        }

        return matrix;
    }
}
