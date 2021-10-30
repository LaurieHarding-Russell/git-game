package src.GitGameEngine;


public interface GitEngineProblem {

    GitEngineMessage setup();

    GitEngineMessage solutionPassing();

    Integer getPoints();
}
