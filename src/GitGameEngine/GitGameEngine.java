package src.GitGameEngine;

import src.GitGameEngine.BasicProblem.CommitProblem;
import src.GitGameEngine.BasicProblem.PushProblem;
import src.GitGameEngine.BasicProblem.SetupRepoProblem;
import src.GitGameEngine.BeginnerProblem.AmendCommitProblem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class GitGameEngine {

    private SetupRepoProblem setupRepoProblem = new SetupRepoProblem();
    private CommitProblem commitProblem = new CommitProblem();
    private PushProblem pushProblem = new PushProblem();

    private AmendCommitProblem amendCommitProblem = new AmendCommitProblem();

    List<GitEngineProblem> gitEngineProblemBasic = List.of(setupRepoProblem, commitProblem);
    List<GitEngineProblem> gitEngineBeginnerBasic = List.of(amendCommitProblem);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String GIT_GAME_LOCATION = "gitGameGameFolder";

    private File gameDirectory;
    
    public GitGameEngine() {}

    public void createGameFolder() {
        gameDirectory = new File("gitGameGameFolder");
        if (!gameDirectory.exists()){
            gameDirectory.mkdirs();
        }
    }
    
    public GitEngineProblem setupBasicProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        GitEngineProblem gitEngineProblem = gitEngineProblemBasic.get((int) (Math.random() * gitEngineProblemBasic.size()));
        return gitEngineProblem;

    }

    public GitEngineProblem setupBeginnerProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        GitEngineProblem gitEngineProblem = gitEngineBeginnerBasic.get((int) (Math.random() * gitEngineBeginnerBasic.size()));
        return gitEngineProblem;
    }

    public GitEngineProblem setupIntermediateProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        GitEngineProblem gitEngineProblem = gitEngineProblemBasic.get((int) (Math.random() * gitEngineProblemBasic.size()));
        return gitEngineProblem;
    }

    public GitEngineProblem setupMasterProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        GitEngineProblem gitEngineProblem = gitEngineProblemBasic.get((int) (Math.random() * gitEngineProblemBasic.size()));
        return gitEngineProblem;
    }

    public GitEngineProblem setupWizardProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        GitEngineProblem gitEngineProblem = gitEngineProblemBasic.get((int) (Math.random() * gitEngineProblemBasic.size()));
        return gitEngineProblem;
    }

    private void deleteDirectoryStream(Path path) throws IOException {
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    private void cleanFolder() {
        try {
            deleteDirectoryStream(gameDirectory.toPath());
            createGameFolder();
        } catch(Exception e) {
            System.err.println("");
        }
    }

}
