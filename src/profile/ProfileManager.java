package profile;

import post.PostData;
import util.UserInputHandler;
import util.json.JsonDataHandler;
import util.presenter.Presenter;

import java.util.ArrayList;

public class ProfileManager {
    public final String SELECT_PROFILE = "Välj Användare:";
    public final String ENTER_NAME = "Skriv Namn:";

    private final JsonDataHandler<ProfileData> dataHandler;
    private final Presenter<ProfileData> presenter;

    private ProfileData profile;

    /**
     * Constructor gets injected with a data handler
     * and a presenter.
     *
     * @param dataHandler responsible for handling data
     * @param presenter   responsible for displaying data
     * @see JsonDataHandler
     * @see Presenter
     */
    public ProfileManager(JsonDataHandler<ProfileData> dataHandler, Presenter<ProfileData> presenter) {
        this.dataHandler = dataHandler;
        this.presenter = presenter;
    }

    /**
     * Fetches all profiles and checks the data, then provides a list
     * of profiles if there are any. Receives user input for selecting
     * profile and set it as current. Returns true or false depending
     * on whether a profile was selected or not.
     *
     * @return whether a profile was selected or not
     */
    public boolean selectProfile() {
        ArrayList<ProfileData> profiles = dataHandler.getAllData();
        if (profiles.isEmpty()) System.out.print("   Inga Användare");
        else {
            System.out.println(SELECT_PROFILE);
            presenter.printAll(profiles);
            System.out.println(profiles.size() + ". Tillbaka");
        }

        int input = UserInputHandler.getInt();
        if (input >= 1 && input <= profiles.size()) {
            int i = input - 1;
            profile = profiles.get(i);
            return true;
        } else if (input > profiles.size() + 1) {
            return false;
        }

        return false;
    }

    /**
     * Creates and saves new profiles
     */
    public void newProfile() {
        profile = createProfile();
        saveProfile(profile);
    }

    /**
     * Receives and stores user input which is then used to
     * create and return a new profile. Handles the created
     * field for the user.
     *
     * @return the profile created
     */
    private ProfileData createProfile() {
        String name = UserInputHandler.getString(ENTER_NAME);
        ArrayList<PostData> postData = new ArrayList<>();
        long created = System.currentTimeMillis();
        return new Profile(name, postData, created);
    }

    /**
     * Provides data to the data handler to be saved and then
     * to the presenter to be displayed.
     *
     * @param profile data to be saved
     */
    private void saveProfile(ProfileData profile) {
        dataHandler.saveData(profile);
        presenter.print(profile);
    }

    /**
     * Returns the selected profile.
     *
     * @return selected profile
     */
    public ProfileData getProfile() {
        return profile;
    }
}
