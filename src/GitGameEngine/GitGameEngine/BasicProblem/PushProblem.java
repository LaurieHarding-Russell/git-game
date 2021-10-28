package src.GitGameEngine.BasicProblem;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class PushProblem implements GitEngineProblem {

    public void setup() {
        System.out.println("push the commit."); // TODO
    }

    public Boolean solutionPassing() {
        return false; // todo
    }

    public Integer getPoints() {
        return 1;
    }
}