package src.GitGameEngine.BasicProblem;

import com.google.common.collect.Iterables;
import org.eclipse.jgit.api.Git;
import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;


public class CommitProblem implements GitEngineProblem {

    public GitEngineMessage setup() {
        try {
            Git git = Git.init().setDirectory( new File("gitGameGameFolder") ).call();
            git.close();
            File aFile = new File(GIT_GAME_LOCATION + "/A.txt"); // TODO, make name funnier.
            aFile.createNewFile();
        } catch (Exception e) {
            // TODO
        }
        return new GitEngineMessage()
                .setMessage("Commit the created A.txt file.");
    }

    public GitEngineMessage solutionPassing() {
        Git git = Git.init().setDirectory( new File("gitGameGameFolder") ).call();
        int countCommits = 0;
        try {
            countCommits = Iterables.size(git.log().call());
        } catch(Exception ignored) {}
        git.close();
        return new GitEngineMessage()
                .setSuccess(countCommits > 0); // FIXME, probably should check if file is actually in git.
    }

    public Integer getPoints() {
        return 1;
    }
}