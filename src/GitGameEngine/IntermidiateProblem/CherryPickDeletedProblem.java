package src.GitGameEngine.IntermidiateProblem;

import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

public class CherryPickDeletedProblem implements GitEngineProblem {

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