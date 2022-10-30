package profile;

import post.PostData;
import util.UserInputHandler;
import util.json.JsonDataHandler;
import util.presenter.Presenter;

import java.util.ArrayList;
import java.util.UUID;

public class ProfileManager {
    public final String SELECT_PROFILE = "Select Profile:";
    public final String ENTER_NAME = "Enter Name:";

    private final JsonDataHandler<ProfileData> dataHandler;
    private final Presenter<ProfileData> presenter;

    public ProfileManager(JsonDataHandler<ProfileData> dataHandler, Presenter<ProfileData> presenter) {
        this.dataHandler = dataHandler;
        this.presenter = presenter;
    }

    public void selectProfile() {
        int input = UserInputHandler.getInt(SELECT_PROFILE);
    }

    public void newProfile() {
        ProfileData profile = createProfile();
        saveProfile(profile);
    }

    public void viewAllProfiles() {
        ArrayList<ProfileData> profiles = dataHandler.getAllData();
        presenter.printAll(profiles);
    }

    private ProfileData createProfile() {
        String name = UserInputHandler.getString(ENTER_NAME);
        ArrayList<PostData> postData = new ArrayList<>();
        long created = System.currentTimeMillis();
        ProfileData profile = new Profile(name, postData, created);

        String id = UUID.fromString(name + created).toString();
        profile.setId(id);

        return profile;
    }

    private void saveProfile(ProfileData profile) {
        dataHandler.saveData(profile);
        presenter.print(profile);
    }
}
