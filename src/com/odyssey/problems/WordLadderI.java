package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class WordLadderI implements IProblem {

    private static int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        int len = 1;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dict.remove(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                char[] cur = q.poll().toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char t = cur[i];
                        cur[i] = c;
                        String next = new String(cur);
                        if (next.equals(endWord)) {
                            return len;
                        }
                        if (dict.remove(next)) {
                            q.offer(next);
                        }
                        cur[i] = t;
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
