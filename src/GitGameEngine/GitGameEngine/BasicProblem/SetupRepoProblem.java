package src.GitGameEngine.BasicProblem;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class SetupRepoProblem implements GitEngineProblem {

    public void setup() {
        System.out.println("Create a git repository");
    }

    public Boolean solutionPassing() {
        try {
            CheckoutCommand git = Git.open(new File(GIT_GAME_LOCATION + "/.git")).checkout();
            Repository repository = git.getRepository();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Integer getPoints() {
        return 1;
    }
}