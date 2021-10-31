package src.GitGameEngine.BeginnerProblem;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;
import src.GitGameEngine.GitEngineHelperFunctions;
import src.GitGameEngine.GitEngineMessage;
import src.GitGameEngine.GitEngineProblem;

import java.io.File;

import static src.GitGameEngine.GitGameEngine.GIT_GAME_LOCATION;

public class AmendCommitProblem implements GitEngineProblem {
    private Git git;

    private PersonIdent friendIdentity = new PersonIdent("Best Friend", "Friend@bff.com"); // FIXME, user generator? Or do we let them customize it?
    private String messageNotSafeForWork = "I love snow";

    public GitEngineMessage setup() {
        try {
            git = Git.init().setDirectory(new File("gitGameGameFolder")).call();
            File aFile = new File(GIT_GAME_LOCATION + "/A.txt"); // Maybe a naming engine?
            aFile.createNewFile();
            git.add().addFilepattern(".").call();
            git.commit().setAuthor(friendIdentity).setMessage(messageNotSafeForWork).call();
        } catch(Exception ignored) {}
        return new GitEngineMessage()
                .setMessage("Oh no! Your friend committed something inappropriate! Help them amend their commit message to anything else!");
    }

    public GitEngineMessage solutionPassing() {
        int count = GitEngineHelperFunctions.getLogCount(git.getRepository());
        RevCommit badCommit = GitEngineHelperFunctions.getHeadCommit(git.getRepository());

            if (count == 1 && badCommit.getFullMessage().equals(messageNotSafeForWork)) { // FIXME, if they do weird stuff this might now technically work.
            git.close();
            return new GitEngineMessage()
                    .setSuccess(true);
        }
        return new GitEngineMessage()
                .setSuccess(false);
    }

    public Integer getPoints() {
        return 10;
    }
}