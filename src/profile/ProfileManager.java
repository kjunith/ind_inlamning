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

    public ProfileManager(JsonDataHandler<ProfileData> dataHandler, Presenter<ProfileData> presenter) {
        this.dataHandler = dataHandler;
        this.presenter = presenter;
    }

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
    
    public void newProfile() {
        profile = createProfile();
        saveProfile(profile);
    }

    private ProfileData createProfile() {
        String name = UserInputHandler.getString(ENTER_NAME);
        ArrayList<PostData> postData = new ArrayList<>();
        long created = System.currentTimeMillis();
        return new Profile(name, postData, created);
    }

    private void saveProfile(ProfileData profile) {
        dataHandler.saveData(profile);
        presenter.print(profile);
    }

    public ProfileData getProfile() {
        return profile;
    }
}
