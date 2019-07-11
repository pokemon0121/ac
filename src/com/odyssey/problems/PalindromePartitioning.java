package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            p[i][i] = true;
        }
        for (int d = 0; d < len; d++) {
            for (int i = 0; i + d < len; i++) {
                p[i][i + d] = s.charAt(i) == s.charAt(i + d) && (d <= 1 || p[i + 1][i + d - 1]);
            }
        }
        dfs(s, 0, ret, new ArrayList<>(), p);
        return ret;
    }

    private void dfs(String s, int idx, List<List<String>> res, List<String> cur, boolean[][] p) {
        int len = s.length();
        if (idx == len) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < len; i++) {
            if (p[idx][i]) {
                cur.add(s.substring(idx, i + 1));
                dfs(s, i + 1, res, cur, p);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
