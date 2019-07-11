package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, 0, dict, new Boolean[s.length() + 1]);
    }

    private boolean dfs(String s, int idx, Set<String> dict, Boolean[] mem) {
        int len = s.length();
        if (mem[idx] != null) {
            return mem[idx];
        }
        if (idx == len) {
            return mem[idx] = true;
        }
        for (int i = idx; i < len; i++) {
            String can = s.substring(idx, i + 1);
            if (dict.contains(can) && dfs(s, i + 1, dict, mem)) {
                return mem[idx] = true;
            }
        }
        return mem[idx] = false;
    }
}
