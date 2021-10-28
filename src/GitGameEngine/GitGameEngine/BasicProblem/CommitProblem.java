package src.GitGameEngine.BasicProblem;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class CommitProblem implements GitEngineProblem {

    public void setup() {
        System.out.println("Commit the created A.txt file.");

        try {
            File aFile = new File(GIT_GAME_LOCATION + "A.txt"); // TODO, make name funnier.
        } catch (Exception e) {
            // TODO
        }
    }

    public Boolean solutionPassing() {
        return false; // TODO
    }

    public Integer getPoints() {
        return 1;
    }
}