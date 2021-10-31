package src.GitGameEngine.BasicProblem;

import com.google.common.collect.Iterables;
import org.eclipse.jgit.api.Git;
import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class CommitProblem implements GitEngineProblem {


    private Git git;

    public GitEngineMessage setup() {
        try {
            git = Git.init().setDirectory( new File("gitGameGameFolder") ).call();
            File aFile = new File(GIT_GAME_LOCATION + "/A.txt"); // TODO, make name funnier.
            aFile.createNewFile();
        } catch (Exception e) {
            // TODO
        }
        return new GitEngineMessage()
                .setMessage("Commit the created A.txt file.");
    }

    public GitEngineMessage solutionPassing() {
        int countCommits = 0;
        try {
            countCommits = Iterables.size(git.log().call());
        } catch(Exception ignored) {}

        git.close();
        return new GitEngineMessage()
                .setSuccess(countCommits > 0);
    }

    public Integer getPoints() {
        return 1;
    }
}