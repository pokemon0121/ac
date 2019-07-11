package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        dfs(ret, s, new StringBuilder(), 0, 3);
        return ret;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int idx, int p) {
        int len = s.length();
        if (p == 0) {
            if (idx == len) {
                sb.setLength(sb.length() - 1);
                res.add(sb.toString());
                return;
            }
        }
        if (idx >= len || ((p + 1) * 3) < (len - idx)) {
            return;
        }
        int preLen = sb.length();
        for (int i = 1; i <= 3; i++) {
            if (idx + i > len) {
                break;
            }
            int val = Integer.valueOf(s.substring(idx, idx + i));
            if (val <= 255) {
                sb.append(val + ".");
                dfs(res, s, sb, idx + i, p - 1);
                sb.setLength(preLen);
            }
            if (val == 0) {
                break;
            }
        }
    }
}
