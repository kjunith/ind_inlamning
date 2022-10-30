package profile;

import post.PostData;

import java.util.ArrayList;

public interface ProfileData {
    void setId(String id);

    String getId();

    String getName();

    ArrayList<PostData> getPostData();

    long getCreated();
}
