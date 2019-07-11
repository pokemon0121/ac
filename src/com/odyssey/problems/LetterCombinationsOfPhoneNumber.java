package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class LetterCombinationsOfPhoneNumber implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> q = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return q;
        }
        List<String> dict = new ArrayList<>(Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
        q.offer("");
        for (char c : digits.toCharArray()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                for (char letter : dict.get(c - '0').toCharArray()) {
                    q.offer(cur + letter);
                }
            }
        }
        return q;
    }
}
