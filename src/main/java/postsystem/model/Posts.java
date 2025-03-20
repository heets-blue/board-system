package postsystem.model;

import java.util.ArrayList;

public class Posts {
    private String title;
    private String body;
    public static ArrayList<Posts> posts = new ArrayList<Posts>();

    public Posts(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return  Posts.posts.indexOf(this)+1 + "번 게시글\n" +
                "제목: " + "[" + title + "]" + '\n' +
                "내용: " + "[" + body + "]" + '\n';
    }
}
