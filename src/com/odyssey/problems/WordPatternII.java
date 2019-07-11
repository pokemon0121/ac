package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

public class WordPatternII implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(str, 0, pattern, 0, new String[26]);
    }

    private boolean dfs(String s, int is, String p, int ip, String[] match) {
        int lenS = s.length();
        int lenP = p.length();
        if (ip == lenP) {
            return is == lenS;
        }
        char cp = p.charAt(ip);
        String curMatch = match[cp - 'a'];
        if (curMatch == null) {
            // give this cp a matching str
            for (int i = is + 1; i <= lenS; i++) {
                match[cp - 'a'] = s.substring(is, i);
                if (isSingle(match, match[cp - 'a']) && dfs(s, i, p, ip + 1, match)) {
                    return true;
                }
                match[cp - 'a'] = null;
            }
        }
        else {
            // cp has a matching str, check
            if (s.substring(is).startsWith(curMatch) && dfs(s, is + curMatch.length(), p, ip + 1, match)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSingle(String[] match, String curMatch) {
        int count = 0;
        for (String m : match) {
            if (m != null && m.equals(curMatch)) {
                count++;
            }
        }
        return count == 1;
    }
}
