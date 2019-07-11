package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates implements IProblem {

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int x, int y) {
        int rows = rooms.length, cols = rooms[0].length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x * cols + y);
        int dis = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int curX = cur / cols, curY = cur % cols;
                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && rooms[nextX][nextY] > 0 && dis < rooms[nextX][nextY]) {
                        rooms[nextX][nextY] = dis;
                        q.offer(nextX * cols + nextY);
                    }
                }
            }
            dis++;
        }
    }
}
