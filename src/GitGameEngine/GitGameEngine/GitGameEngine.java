package src.GitGameEngine;

import src.GitGameEngine.BasicProblem.SetupRepoProblem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class GitGameEngine {

    private Integer score = 0;

    private static SetupRepoProblem setupRepoProblem = new SetupRepoProblem();

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

    public void cleanFolder() {
        try {
            deleteDirectoryStream(gameDirectory.toPath());
            createGameFolder();
        } catch(Exception e) {
            System.err.println("");
        }
    }
    
    public void setupBasicProblem() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        cleanFolder();
        setupRepoProblem.setup();
//        FIXME, Think about this.
        try {
            do {
                Thread.sleep(100);
            }while(!setupRepoProblem.solutionPassing());

            score = score + setupRepoProblem.getPoints();
            System.out.println("Score " + score);
        } catch(Exception e) {
            System.err.println("Huh, something broken. " + e);
        }

    }

    public void setupBeginnerProblem() {

    }

    public void setupIntermediateProblem() {

    }

    public void setupMasterProblem() {

    }

    public void setupWizardProblem() {

    }

    private void deleteDirectoryStream(Path path) throws IOException {
        Files.walk(path)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

}
