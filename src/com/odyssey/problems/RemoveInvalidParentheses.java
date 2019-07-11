package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new ArrayList<>();
        int rmL = 0, rmR = 0, diff = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rmL++;
                diff++;
            }
            else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                }
                else {
                    rmR++;
                }
                diff--;
            }
        }
        dfs(s, ret, new StringBuilder(), rmL, rmR, 0, 0);
        return ret;
    }

    private void dfs(String s, List<String> res, StringBuilder path, int rmL, int rmR, int idx, int diff) {
        if (idx == s.length() && rmL == 0 && rmR == 0 && diff == 0) {
            res.add(path.toString());
            return;
        }
        if (idx >= s.length() || diff < 0) {
            return;
        }
        char cur = s.charAt(idx);
        int preLen = path.length();
        if (s.charAt(idx) == '(' && rmL > 0) {
            // remove (
            int j = idx + 1;
            while (j < s.length() && s.charAt(j) == cur) {
                j++;
            }
            dfs(s, res, path, rmL - j + idx, rmR, j, diff);
        }
        if (s.charAt(idx) == ')' && rmR > 0) {
            // remove )
            int j = idx + 1;
            while (j < s.length() && s.charAt(j) == cur) {
                j++;
            }
            dfs(s, res, path, rmL, rmR - j + idx, j, diff);
        }
        // keep
        dfs(s, res, path.append(cur), rmL, rmR, idx + 1, diff + (cur == '(' ? 1 : (cur == ')' ? -1 : 0)));
        path.setLength(preLen);
    }
}
