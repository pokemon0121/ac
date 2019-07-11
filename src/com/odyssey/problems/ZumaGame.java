package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashMap;
import java.util.Map;

public class ZumaGame implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private int minStep = Integer.MAX_VALUE;

    public int findMinStep(String board, String hand) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        dfs(board, map, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void dfs(String board, Map<Character, Integer> hand, int step) {
        int len = board.length();
        if (len == 0) {
            minStep = Math.min(minStep, step);
            return;
        }
        if (hand.isEmpty()) {
            return;
        }
        for (int i = 0; i < len; i++) {
            char cur = board.charAt(i);
            Integer balls = hand.get(cur);
            if (i + 1 < len && board.charAt(i + 1) == cur && balls != null) {
                // use 1 ball
                if (balls == 1) {
                    hand.remove(cur);
                }
                else {
                    hand.put(cur, balls - 1);
                }
                dfs(clearBoard(board, i - 1, i + 2), hand, step + 1);
            }
            else if (balls != null && balls >= 2) {
                // use 2 balls
                if (balls == 2) {
                    hand.remove(cur);
                }
                else {
                    hand.put(cur, balls - 2);
                }
                dfs(clearBoard(board, i - 1, i + 1), hand, step + 2);
            }
            hand.put(cur, balls);
        }
    }

    private String clearBoard(String oldBoard, int left, int right) {
        int l = left, r = right;
        int len = oldBoard.length();
        while (l >= 0 && r < len && oldBoard.charAt(l) == oldBoard.charAt(r)) {
            int i = l, j = r;
            while (i >= 0 && oldBoard.charAt(l) == oldBoard.charAt(i)) {
                i--;
            }
            while (j < len && oldBoard.charAt(r) == oldBoard.charAt(j)) {
                j++;
            }
            if (j - r + l - i > 2) {
                l = i;
                r = j;
            }
            else {
                break;
            }
        }
        return oldBoard.substring(0, l + 1) + oldBoard.substring(r);
    }
}
