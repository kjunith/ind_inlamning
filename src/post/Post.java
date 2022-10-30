package post;

public class Post implements PostData {
    private final String title;
    private final String content;
    private final long date;

    public Post(String title, String content, long date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

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
