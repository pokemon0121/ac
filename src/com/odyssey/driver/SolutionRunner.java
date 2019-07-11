package com.odyssey.driver;

import com.odyssey.interfaces.IProblem;
import com.odyssey.problems.WordLadderII;

public class SolutionRunner {

    public static void main(String[] args) {
	    IProblem problem = new WordLadderII();
	    problem.init();
        problem.solve();
    }
}
