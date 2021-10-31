package src.GitGameEngine.BasicProblem;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class SetupRepoProblem implements GitEngineProblem {

    public GitEngineMessage setup() {
        return new GitEngineMessage()
                .setMessage("Create a git repository");
    }

    public GitEngineMessage solutionPassing() {
        try {
            CheckoutCommand git = Git.open(new File(GIT_GAME_LOCATION + "/.git")).checkout();
            Repository repository = git.getRepository();
            repository.close(); // FIXME... closing
            return new GitEngineMessage()
                    .setSuccess(true);
        } catch (Exception e) {
            return new GitEngineMessage()
                    .setSuccess(false);
        }
    }

    public Integer getPoints() {
        return 1;
    }
}