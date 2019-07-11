package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumUniqueWordAbbreviation implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private String ret;
    private int minLen = Integer.MAX_VALUE;

    public String minAbbreviation(String target, String[] dictionary) {
        int m = target.length();
        List<String> dict = new ArrayList<>();
        for (String s : dictionary) {
            if (s.length() == m) {
                dict.add(s);
            }
        }
        dfs(new StringBuilder(), 0, 0, target, dict, 0);
        return ret;
    }

    private void dfs(StringBuilder curString, int cur, int idx, String s, List<String> strs, int lenCounter) {
        int len = s.length();
        int preLen = curString.length();
        if (idx == len) {
            if (cur > 0) {
                curString.append(cur);
                lenCounter++;
            }
            String can = curString.toString();
            curString.setLength(preLen);
            if (lenCounter < minLen && check(can, strs)) {
                minLen = lenCounter;
                ret = can;
            }
            return;
        }
        // compress
        dfs(curString, cur + 1, idx + 1, s, strs, lenCounter);
        // keep
        int nextLenCounter = lenCounter;
        if (cur > 0) {
            curString.append(cur);
            nextLenCounter++;
        }
        curString.append(s.charAt(idx));
        dfs(curString, 0, idx + 1, s, strs, nextLenCounter + 1);
        curString.setLength(preLen);
    }

    private boolean check(String can, List<String> strs) {
        StringBuilder unzipped = new StringBuilder();
        int len = can.length();
        int i = 0;
        // restore
        while (i < len) {
            if (Character.isLetter(can.charAt(i))) {
                unzipped.append(can.charAt(i++));
            }
            else {
                int j = i + 1;
                int c = can.charAt(i) - '0';
                while (j < len && !Character.isLetter(can.charAt(j))) {
                    c = c * 10 + can.charAt(j) - '0';
                }
                for (int k = 0; k < c; k++) {
                    unzipped.append('_');
                }
                i = j;
            }
        }
        String unzippedStr = unzipped.toString();
        // sort
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int len = a.length();
                for (int i = 0; i < len; i++) {
                    if (unzippedStr.charAt(i) == '_') {
                        continue;
                    }
                    else if (a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
        });
        // search
        int pos = Collections.binarySearch(strs, unzippedStr, new Comparator<String>() {
            @Override
            public int compare(String val, String key) {
                int len = val.length();
                for (int i = 0; i < len; i++) {
                    if (key.charAt(i) == '_') {
                        continue;
                    }
                    else if (key.charAt(i) != val.charAt(i)) {
                        return val.compareTo(key);
                    }
                }
                return 0;
            }
        });
        return pos < 0;
    }
}
