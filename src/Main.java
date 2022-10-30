import menu.Menu;
import menu.MenuState;
import post.PostManager;
import profile.ProfileManager;
import util.UserInputHandler;
import util.json.PostDataHandler;
import util.json.ProfileDataHandler;
import util.presenter.PostPresenter;
import util.presenter.ProfilePresenter;

public class Main {
    private final static Menu MENU = new Menu();
    private final static PostManager postManager = new PostManager(new PostDataHandler(), new PostPresenter());
    private final static ProfileManager profileManager = new ProfileManager(new ProfileDataHandler(), new ProfilePresenter());
    private static boolean running;

    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        running = true;
        while (running) {
            switch (MENU.getState()) {
                case READ -> readPosts();
                case WRITE -> writePost();
                case EXIT -> exitProgram();
                case PROFILE -> showProfiles();
                default -> showMenu();
            }

            awaitUserInput();
        }

        System.exit(0);
    }

    private static void awaitUserInput() {
        if (MENU.getState() == MenuState.PROFILE) {
            System.out.println("Profiles Input...");
        } else if (MENU.getState() == MenuState.EXIT) {
            exitProgram();
        } else {
            System.out.println("Menu Input...");
            int option = UserInputHandler.getInt();
            if (option > 0 && option < MenuState.values().length) MENU.setState(MenuState.values()[option]);
        }
        System.out.print(System.lineSeparator());
    }

    private static void showProfiles() {
        profileManager.viewAllProfiles();
    }

    private static void showMenu() {
        MENU.show();
    }

    private static void readPosts() {
        postManager.viewAllPosts();
        MENU.setState(MenuState.PROFILE);
    }

    private static void writePost() {
        postManager.writeNewPost();
        MENU.setState(MenuState.MAIN);
    }

    private static void exitProgram() {
        System.out.println("Hejdå, Användare!");
        running = false;
    }
}
