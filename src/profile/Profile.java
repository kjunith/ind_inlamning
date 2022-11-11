package profile;

import post.PostData;

import java.util.ArrayList;

public class Profile implements ProfileData {
    private final String name;
    private final ArrayList<PostData> postData;
    private final long created;

    /**
     * Constructor used to create Profile instances with a
     * name, postData, and date created.
     *
     * @param name     the title
     * @param postData the content
     * @param created  the date the post was created
     */
    public Profile(String name, ArrayList<PostData> postData, long created) {
        this.name = name;
        this.postData = postData;
        this.created = created;
    }

    /**
     * Returns the name of this profile.
     *
     * @return profile name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns a list containing all the posts from profile.
     *
     * @return all posts from profile
     */
    @Override
    public ArrayList<PostData> getPostData() {
        return postData;
    }

    /**
     * Returns a long representing the date
     * for when this profile was created.
     *
     * @return the date the profile was created
     */
    @Override
    public long getCreated() {
        return created;
    }
}
