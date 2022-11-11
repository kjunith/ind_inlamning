package util.presenter;

import profile.ProfileData;

import java.util.ArrayList;

public class ProfilePresenter implements Presenter<ProfileData> {

    /**
     * Takes a list of profiles and presents to user
     * with numbers pointing to the index of the profile
     *
     * @param profile printed profile
     * @param i       printed array index
     */
    private void printWithIndex(ProfileData profile, int i) {
        System.out.print((i + 1) + ". ");
        print(profile);
    }

    /**
     * Method takes a profile and presents it to  user
     *
     * @param profile profile data
     */
    @Override
    public void print(ProfileData profile) {
        System.out.println(profile.getName());
    }

    /**
     * Takes a list of profiles and presents to user
     *
     * @param profiles§ list of profiles
     */
    @Override
    public void printAll(ArrayList<ProfileData> profiles) {
        profiles.forEach(profileData -> printWithIndex(profileData, profiles.indexOf(profileData)));
    }
}
