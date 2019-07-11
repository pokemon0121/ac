package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ret, new ArrayList<>(), 0, candidates, 0, target);
        return ret;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int idx, int[] cans, int curSum, int target) {
        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int len = cans.length;
        if (idx >= len || curSum > target) {
            return;
        }
        curSum += cans[idx];
        cur.add(cans[idx]);
        dfs(res, cur, idx + 1, cans, curSum, target);
        cur.remove(cur.size() - 1);
        curSum -= cans[idx];
        int j = idx + 1;
        while (j < len && cans[j] == cans[idx]) {
            j++;
        }
        dfs(res, cur, j, cans, curSum, target);
    }
}
