package util.presenter;

import post.PostData;
import post.PostFormatter;

import java.util.ArrayList;

public class PostPresenter implements Presenter<PostData> {

    /**
     * Method takes a post and presents it to  user
     *
     * @param post post data
     */
    @Override
    public void print(PostData post) {
        String date = PostFormatter.toFull(post.getDate());
        String content = post.getContent();
        String title = post.getTitle();
        System.out.println(title + System.lineSeparator() + content + System.lineSeparator() + date + System.lineSeparator());
    }

    /**
     * Takes a list of posts and presents to user
     *
     * @param posts list of posts
     */
    @Override
    public void printAll(ArrayList<PostData> posts) {
        posts.forEach(this::print);
    }
}
