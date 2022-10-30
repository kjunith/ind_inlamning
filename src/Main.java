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
    private final static ProfileManager profileManager = new ProfileManager(new ProfileDataHandler(), new ProfilePresenter());
    private final static PostManager postManager = new PostManager(new PostDataHandler(), new PostPresenter());
    private static ProfileData profile = null;

    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        while (true) {
            System.out.println("Aktiv Användare: " + getUserName());
            MAIN_MENU.show();
            getUserInput();
        }
    }

    private static String getUserName() {
        return profile == null ? NO_USER : profile.getName();
    }

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
                        case 1 -> postManager.viewPosts();
                        case 2 -> postManager.writePost();
                        case 3 -> MAIN_MENU.setState(MenuState.PROFILE);
                        case 4 -> exitProgram();
                    }
            }
        }
        System.out.print(System.lineSeparator());
    }

    private static void exitProgram() {
        System.out.print(System.lineSeparator());
        System.out.println("Hejdå, " + getUserName() + "!");
        System.exit(0);
    }
}
