package com.odyssey.problems;

import com.odyssey.interfaces.IProblem;

import java.util.*;

public class OpenTheLock implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    public int openLock(String[] deadends, String target) {
        if (deadends == null || target == null) {
            return -1; // throw
        }
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendsSet.contains("0000")) {
            return -1;
        }
        int steps = 0;
        Queue<char[]> q = new LinkedList<>();
        q.offer(new char[]{'0', '0', '0', '0'});
        Set<String> used = new HashSet<>();
        used.add("0000");
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            while (size-- > 0) {
                char[] cur = q.poll();
                for (int i = 0; i < cur.length; i++) {
                    char t = cur[i];
                    cur[i]++;
                    if (!Character.isDigit(cur[i])) {
                        cur[i] = '0';
                    }
                    String next = new String(cur);
                    cur[i] = t;
                    if (target.equals(next)) {
                        return steps;
                    }
                    if (used.add(next) && !deadendsSet.contains(next)) {
                        q.offer(next.toCharArray());
                    }
                    cur[i]--;
                    if (!Character.isDigit(cur[i])) {
                        cur[i] = '9';
                    }
                    next = new String(cur);
                    cur[i] = t;
                    if (target.equals(next)) {
                        return steps;
                    }
                    if (used.add(next) && !deadendsSet.contains(next)) {
                        q.offer(next.toCharArray());
                    }
                }
            }
        }
        return -1;
    }
}
