package src.GitGameEngine.WizardProblem;

import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

public class GitNotesProblem implements GitEngineProblem {

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