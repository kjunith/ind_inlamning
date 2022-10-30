package util.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import post.PostData;
import profile.Profile;
import profile.ProfileData;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class ProfileDataHandler extends JsonDataHandler<ProfileData> {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String POST_DATA = "post_data";
    public static final String CREATED = "created";

    public ProfileDataHandler() {
        super("profiles.json");
    }

    @Override
    public ProfileData objectFromData(JSONObject data) {
        String name = (String) data.get(NAME);

        JSONArray jsonArray = (JSONArray) data.get(POST_DATA);
        ArrayList<PostData> postData = new ArrayList<PostData>(jsonArray);

        long created = (long) data.get(CREATED);
        ProfileData profileData = new Profile(name, postData, created);

        String id = (String) data.get(ID);
        profileData.setId(id);

        return profileData;
    }

    @Override
    public JSONObject dataFromObject(ProfileData profile) {
        JSONObject profileData = new JSONObject();
        profileData.put(ID, profile.getId());
        profileData.put(NAME, profile.getName());

        JSONArray postData = new JSONArray();
        postData.addAll(profile.getPostData());
        profileData.put(POST_DATA, profile.getPostData());

        profileData.put(CREATED, profile.getCreated());
        return profileData;
    }
}
