package profile;

import post.PostData;

import java.util.ArrayList;

public class Profile implements ProfileData {
    private String id;
    private final String name;
    private final ArrayList<PostData> postData;
    private final long created;

    public Profile(String name, ArrayList<PostData> postData, long created) {
        this.name = name;
        this.postData = postData;
        this.created = created;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<PostData> getPostData() {
        return postData;
    }

    @Override
    public long getCreated() {
        return created;
    }
}
