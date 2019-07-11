package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class WordSearch implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int idx, String word, boolean[][] visited) {
        int len = word.length();
        int row = board.length, col = board[0].length;
        if (idx == len) {
            return true;
        }
        if (i >= row || i < 0 || j >= col || j < 0 || visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        visited[i][j] = true;
        boolean exist = dfs(board, i + 1, j, idx + 1, word, visited) || dfs(board, i, j + 1, idx + 1, word, visited) || dfs(board, i - 1, j, idx + 1, word, visited) || dfs(board, i, j - 1, idx + 1, word, visited);
        visited[i][j] = false;
        return exist;
    }
}
