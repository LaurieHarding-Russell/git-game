package src.GitGameEngine.BeginnerProblem;

import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

public class StashProblem implements GitEngineProblem {

    public GitEngineMessage setup() {
        return new GitEngineMessage();
    }

    public GitEngineMessage solutionPassing() {
        return new GitEngineMessage();
    }

    public Integer getPoints() {
        return 2;
    }
}