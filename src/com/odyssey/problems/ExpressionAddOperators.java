package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        dfs(num, ret, new StringBuilder(), 0, 0, 0, target);
        return ret;
    }

    private void dfs(String num, List<String> res, StringBuilder path, int idx, long eval, long cache, int target) {
        int len = num.length();
        if (idx == len) {
            if (eval == target) {
                res.add(path.toString());
            }
            return;
        }
        int preLen = path.length();
        long val = 0;
        for (int i = idx; i < len; i++) {
            val = val * 10 + num.charAt(i) - '0';
            if (path.length() == 0) {
                path.append(val);
                dfs(num, res, path, i + 1, eval + val, val, target);
                path.setLength(preLen);
            }
            else {
                // +
                path.append("+" + val);
                dfs(num, res, path, i + 1, eval + val, val, target);
                path.setLength(preLen);
                // -
                path.append("-" + val);
                dfs(num, res, path, i + 1, eval - val, -val, target);
                path.setLength(preLen);
                // *
                path.append("*" + val);
                dfs(num, res, path, i + 1, eval - cache + cache * val, cache * val, target);
                path.setLength(preLen);
            }
            if (val == 0) {
                break;
            }
        }
    }
}
