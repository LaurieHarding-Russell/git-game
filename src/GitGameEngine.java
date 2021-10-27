package src;

import java.io.File;

public class GitGameEngine {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    
    public GitGameEngine() {}

    public void createGameFolder() {
        System.out.println("Please enter following command into a terminal to go to the git game folder.");
        System.out.println(ANSI_BLUE + "cd " + System.getProperty("user.dir") + "/" + "gitGameGameFolder" + ANSI_RESET);
        File theDir = new File("gitGameGameFolder");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
    }
    

}
