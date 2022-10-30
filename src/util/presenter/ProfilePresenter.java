package util.presenter;

import profile.ProfileData;

import java.util.ArrayList;

public class ProfilePresenter implements Presenter<ProfileData> {
    private void printWithIndex(ProfileData profile, int i) {
        System.out.print((i + 1) + ". ");
        print(profile);
    }

    @Override
    public void print(ProfileData profile) {
        System.out.println(profile.getName());
    }

    @Override
    public void printAll(ArrayList<ProfileData> profiles) {
        profiles.forEach(profileData -> printWithIndex(profileData, profiles.indexOf(profileData)));
    }
}
