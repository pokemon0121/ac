package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.Arrays;

public class DungeonGame implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        int row = dungeon.length, col = dungeon[0].length;
        int[] hp = new int[col];
        Arrays.fill(hp, Integer.MAX_VALUE);
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    hp[j] = Math.max(0, -dungeon[i][j]);
                }
                else {
                    hp[j] = Math.max(0, Math.min(j < col - 1 ? hp[j + 1] : Integer.MAX_VALUE, i < row - 1 ? hp[j] : Integer.MAX_VALUE) - dungeon[i][j]);
                }
            }
        }
        return hp[0] + 1;
    }
}
