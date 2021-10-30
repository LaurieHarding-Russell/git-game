package src.GitGameEngine.BasicProblem;

import com.google.common.collect.Iterables;
import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class CommitProblem implements GitEngineProblem {


    Git git;

    public void setup() {
        System.out.println("Commit the created A.txt file.");
        try {
            git = Git.init().setDirectory( new File("gitGameGameFolder") ).call();
            File aFile = new File(GIT_GAME_LOCATION + "A.txt"); // TODO, make name funnier.
        } catch (Exception e) {
            // TODO
        }
    }

    public Boolean solutionPassing() {
        int countCommits = 0;
        try {
            countCommits = Iterables.size(git.log().call());
        } catch(Exception e) {}
        return countCommits > 0;
    }

    public Integer getPoints() {
        return 1;
    }
}