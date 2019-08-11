package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.Arrays;

public class DecodeWays implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int numDecodings(String s) {
        int[] mem = new int[s.length() + 1];
        Arrays.fill(mem, -1);
        return dfs(s, 0, mem);
    }

    private int dp(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int pp = 1, p;
        int first2 = Integer.valueOf(s.substring(0, 2));
        if (first2 <= 26 && first2 % 10 != 0) {
            p = 2;
        }
        else {
            p = 1;
        }
        for (int i = 2; i < len; i++) {
            int cur = s.charAt(i) == '0' ? 0 : p;
            int val = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (val <= 26 && val % 10 != 0) {
                cur += pp;
            }
            pp = p;
            p = cur;
        }
        return p;
    }

    private int dfs(String s, int idx, int[] mem) {
        int len = s.length();
        if (idx == len) {
            return 1;
        }
        for (int i = idx + 1; i <= len; i++) {
            int cur = Integer.valueOf(s.substring(idx, i));
            if (cur == 0 || cur > 26) {
                break;
            }
            if (mem[i] > 0) {
                mem[idx] += mem[i];
            }
            else {
                mem[idx] += dfs(s, i, mem);
            }
        }
        return mem[idx] = 0;
    }
}
