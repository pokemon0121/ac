package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), 0, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, k, n);
        return ret;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int idx, int[] cans, int curSum, int k, int target) {
        if (cur.size() == k) {
            if (curSum == target) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        int len = cans.length;
        if (idx >= len || curSum > target) {
            return;
        }
        curSum += cans[idx];
        cur.add(cans[idx]);
        dfs(res, cur, idx + 1, cans, curSum, k, target);
        cur.remove(cur.size() - 1);
        curSum -= cans[idx];
        dfs(res, cur, idx + 1, cans, curSum, k, target);
    }
}
