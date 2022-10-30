package util.json;

import org.json.simple.JSONObject;
import post.Post;
import post.PostData;

@SuppressWarnings("unchecked")
public class PostDataHandler extends JsonDataHandler<PostData> {
    public static final String TITLE = "title";
    public static final String CONTENT = "content";
    public static final String DATE = "date";

    public PostDataHandler() {
        super("posts.json");
    }

    @Override
    public PostData objectFromData(JSONObject data) {
        String title = (String) data.get(TITLE);
        String content = (String) data.get(CONTENT);
        long date = (long) data.get(DATE);
        return new Post(title, content, date);
    }

    @Override
    public JSONObject dataFromObject(PostData post) {
        JSONObject postData = new JSONObject();
        postData.put(TITLE, post.getTitle());
        postData.put(CONTENT, post.getContent());
        postData.put(DATE, post.getDate());
        return postData;
    }
}
