package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n < 1) {
            return ret;
        }
        dfs(ret, new StringBuilder(), n, n, 0);
        return ret;
    }

    private void dfs(List<String> res, StringBuilder cur, int left, int right, int diff) {
        if (left == 0 && right == 0 && diff == 0) {
            res.add(cur.toString());
            return;
        }
        if (left < 0 || right < 0 || diff < 0) {
            return;
        }

        cur.append('(');
        dfs(res, cur, left - 1, right, diff + 1);
        cur.deleteCharAt(cur.length() - 1);
        if (diff > 0) {
            cur.append(')');
            dfs(res, cur, left, right - 1, diff - 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
