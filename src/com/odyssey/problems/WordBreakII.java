package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class WordBreakII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] mem = new boolean[s.length() + 1];
        Arrays.fill(mem, true);
        dfs(ret, new StringBuilder(), s, 0, dict, new boolean[s.length() + 1]);
        return ret;
    }

    private void dfs(List<String> ret, StringBuilder cur, String s, int idx, Set<String> dict, boolean[] mem) {
        int len = s.length();
        int preLen = cur.length();
        int retSize = ret.size();
        if (idx == len) {
            ret.add(cur.toString());
            return;
        }
        for (int i = idx; i < len; i++) {
            String can = s.substring(idx, i + 1);
            if (dict.contains(can) && mem[i + 1]) {
                cur.append(can).append(i + 1 == len ? "" : " ");
                dfs(ret, cur, s, i + 1, dict, mem);
                cur.setLength(preLen);
            }
        }
        if (retSize == ret.size()) {
            mem[idx] = false;
        }
    }
}
