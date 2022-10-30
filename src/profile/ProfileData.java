package profile;

import post.PostData;

import java.util.ArrayList;

public interface ProfileData {
    String getName();

    ArrayList<PostData> getPostData();

    long getCreated();
}
