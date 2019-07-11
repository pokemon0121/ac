package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class RegularExpressionMatching implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }

    private boolean dfs(String s, int is, String p, int ip, Boolean[][] mem) {
        int lenS = s.length();
        int lenP = p.length();
        if (ip == lenP) {
            return is == lenS;
        }
        if (is > lenS) {
            return false;
        }
        if (mem[is][ip] != null) {
            return mem[is][ip];
        }
        // . or equal
        if (ip == lenP - 1 || p.charAt(ip + 1) != '*') {
            if (is < lenS && p.charAt(ip) == s.charAt(is) || p.charAt(ip) == '.') {
                return mem[is][ip] = dfs(s, is + 1, p, ip + 1, mem);
            }
            else {
                return mem[is][ip] = false;
            }
        }
        // *
        int i = is - 1;
        while (i < lenS && (i == is - 1 || s.charAt(i) == p.charAt(ip) || p.charAt(ip) == '.')) {
            if (dfs(s, i + 1, p, ip + 2, mem)) {
                return mem[is][ip] = true;
            }
            i++;
        }
        return mem[is][ip] = false;
    }
}
