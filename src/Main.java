import menu.MainMenu;
import menu.MenuState;
import post.PostManager;
import profile.ProfileData;
import profile.ProfileManager;
import util.UserInputHandler;
import util.json.PostDataHandler;
import util.json.ProfileDataHandler;
import util.presenter.PostPresenter;
import util.presenter.ProfilePresenter;

public class Main {
    public static final String NO_USER = "Ingen";
    private final static MainMenu MAIN_MENU = new MainMenu();
    private final static ProfileManager profileManager = new ProfileManager(new ProfileDataHandler(),
            new ProfilePresenter());
    private final static PostManager postManager = new PostManager(new PostDataHandler(), new PostPresenter());
    private static ProfileData profile = null;

    public static void main(String[] args) {
        startProgram();
    }

    /**
     * Runs the program in an infinite while loop and
     * prints out the current active user, even if
     * no user is currently active.
     * <p>
     * Prints out the current state of the MainMenu
     * class which displays a menu for either posts
     * or profiles and then awaits user input.
     *
     * @see MainMenu
     */
    private static void startProgram() {
        while (true) {
            System.out.println("Aktiv Användare: " + getUserName());
            MAIN_MENU.show();
            getUserInput();
        }
    }

    /**
     * Checks for an active user and retrieves the
     * users profile name.
     * This always returns a value.
     *
     * @return the name of the current active user
     */
    private static String getUserName() {
        return profile == null ? NO_USER : profile.getName();
    }

    /**
     * Retrieves user input in form of an Integer
     * which is used to navigate through the current
     * menu and handles the different states.
     * <p>
     * User input is used to make calls to different
     * data handlers. They in turn, are then used to
     * display the correct info for the user.
     *
     * @see ProfileManager
     * @see PostManager
     */
    private static void getUserInput() {
        int option = UserInputHandler.getInt();
        switch (MAIN_MENU.getState()) {
            case PROFILE -> {
                if (option >= 1 && option <= MAIN_MENU.getProfileOptions().length)
                    switch (option) {
                        case 1 -> {
                            if (profileManager.selectProfile()) {
                                profile = profileManager.getProfile();
                                MAIN_MENU.setState(MenuState.POST);
                            }
                        }
                        case 2 -> {
                            profileManager.newProfile();
                            MAIN_MENU.setState(MenuState.POST);
                        }
                        case 3 -> exitProgram();
                    }
            }
            case POST -> {
                if (option >= 1 && option <= MAIN_MENU.getPostOptions().length)
                    switch (option) {
                        case 1 -> postManager.viewPosts(profile);
                        case 2 -> postManager.writePost(profile);
                        case 3 -> MAIN_MENU.setState(MenuState.PROFILE);
                        case 4 -> exitProgram();
                    }
            }
        }
        System.out.print(System.lineSeparator());
    }

    /**
     * Displays a goodbye message and exits the program.
     */
    private static void exitProgram() {
        System.out.print(System.lineSeparator());
        System.out.println("Hejdå, " + getUserName() + "!");
        System.exit(0);
    }
}
