package post;

public class Post implements PostData {
    private final String title;
    private final String content;
    private final long date;

    /**
     * Constructor used to create Post instances with a
     * title, content, and date created.
     *
     * @param title   the title
     * @param content the content
     * @param date    the date the post was created
     */
    public Post(String title, String content, long date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    /**
     * Returns a String representing the title
     * of this post.
     *
     * @return the title of the post
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Returns a String representing the content
     * of this post.
     *
     * @return the content of post
     */
    @Override
    public String getContent() {
        return content;
    }

    /**
     * Returns a long representing the date
     * for when this post was created.
     *
     * @return the date the post was created
     */
    @Override
    public long getDate() {
        return date;
    }

    @Override
    public String toString() {
        return title + System.lineSeparator() +
                content + System.lineSeparator() +
                date + System.lineSeparator();
    }
}
