package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.HashMap;
import java.util.Map;

public class FlipGameII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean canWin(String s) {
        return canWin(s.toCharArray(), new HashMap<>());
    }

    private boolean canWin(char[] s, Map<String, Boolean> mem) {
        int len = s.length;
        Boolean val = mem.get(new String(s));
        if (val != null) {
            return val;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = s[i + 1] = '-';
                boolean ret = canWin(s, mem);
                s[i] = s[i + 1] = '+';
                if (!ret) {
                    mem.put(new String(s), true);
                    return true;
                }
            }
        }
        mem.put(new String(s), false);
        return false;
    }
}
