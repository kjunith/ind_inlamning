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

    /**
     * Constructor gets injected with a data handler
     * and a presenter.
     *
     * @param dataHandler responsible for handling data
     * @param presenter   responsible for displaying data
     * @see JsonDataHandler
     * @see Presenter
     */
    public PostManager(JsonDataHandler<PostData> dataHandler, Presenter<PostData> presenter) {
        this.dataHandler = dataHandler;
        this.presenter = presenter;
    }

    /**
     * Contains methods to creating and saving posts.
     *
     * @param profileData current active user, under development
     */
    public void writePost(ProfileData profileData) {
        PostData post = createPost(profileData);
        savePostData(post);
    }

    /**
     * Fetches data from the data handler and sends it
     * to the presenter to be displayed for the user.
     *
     * @param profileData current active user, under development
     */
    public void viewPosts(ProfileData profileData) {
        ArrayList<PostData> posts = dataHandler.getAllData();
        presenter.printAll(posts);
    }

    /**
     * Receives and stores user input which is then used to
     * create and return a new post.
     *
     * @param profileData current active user, under development
     * @return the post created
     */
    private PostData createPost(ProfileData profileData) {
        String title = UserInputHandler.getString(ENTER_TITLE);
        String content = UserInputHandler.getString(ENTER_CONTENT);
        long date = System.currentTimeMillis();
        System.out.print(System.lineSeparator());
        return new Post(title, content, date);
    }

    /**
     * Provides data to the data handler to be saved and then
     * to the presenter to be displayed.
     *
     * @param postData data to be saved
     */
    private void savePostData(PostData postData) {
        dataHandler.saveData(postData);
        presenter.print(postData);
    }
}
