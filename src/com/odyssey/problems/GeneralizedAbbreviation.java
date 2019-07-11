package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<>();
        dfs(ret, new StringBuilder(), word, 0, 0);
        return ret;
    }

    private void dfs(List<String> res, StringBuilder path, String word, int idx, int count) {
        int len = word.length();
        int preLen = path.length();
        if (idx == len) {
            res.add(path.append(count > 0 ? count : "").toString());
            path.setLength(preLen);
            return;
        }
        // compress
        dfs(res, path, word, idx + 1, count + 1);
        // keep
        dfs(res, path.append(count > 0 ? count : "").append(word.charAt(idx)), word, idx + 1, 0);
        path.setLength(preLen);
    }
}
