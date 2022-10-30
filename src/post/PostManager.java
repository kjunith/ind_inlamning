package post;

import profile.ProfileData;
import util.UserInputHandler;
import util.json.JsonDataHandler;
import util.presenter.Presenter;

import java.util.ArrayList;

public class PostManager {
    public final String ENTER_TITLE = "Enter Title:";
    public final String ENTER_CONTENT = "Enter Content:";

    private final JsonDataHandler<PostData> dataHandler;
    private final Presenter<PostData> presenter;

    public PostManager(JsonDataHandler<PostData> dataHandler, Presenter<PostData> presenter) {
        this.dataHandler = dataHandler;
        this.presenter = presenter;
    }

    public void writePost(ProfileData profileData) {
        PostData post = createPost(profileData);
        savePostData(post);
    }

    public void viewPosts(ProfileData profileData) {
        ArrayList<PostData> posts = dataHandler.getAllData();
        presenter.printAll(posts);
    }

    private PostData createPost(ProfileData profileData) {
        String title = UserInputHandler.getString(ENTER_TITLE);
        String content = UserInputHandler.getString(ENTER_CONTENT);
        long date = System.currentTimeMillis();
        System.out.print(System.lineSeparator());
        return new Post(title, content, date);
    }

    private void savePostData(PostData postData) {
        dataHandler.saveData(postData);
        presenter.print(postData);
    }
}
