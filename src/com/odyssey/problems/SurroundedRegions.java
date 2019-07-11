package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0] == null || board[0].length <= 2) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    flip(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flip(char[][] board, int x, int y) {
        int rows = board.length, cols = board[0].length;
        board[x][y] = 'Y';
        List<Integer> area = new ArrayList<>();
        int pos = 0;
        boolean connectedToOutside = false;
        area.add(x * cols + y);
        while (pos < area.size()) {
            int cur = area.get(pos++);
            int curX = cur / cols;
            int curY = cur % cols;
            board[curX][curY] = 'Y';
            if (curX == 0 || curX == rows - 1 || curY == 0 || curY == cols - 1) {
                connectedToOutside = true;
            }
            for (int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && board[nextX][nextY] == 'O') {
                    area.add(nextX * cols + nextY);
                    board[nextX][nextY] = 'Y';
                }
            }
        }
        if (!connectedToOutside) {
            for (int cur : area) {
                board[cur / cols][cur % cols] = 'X';
            }
        }
    }
}
