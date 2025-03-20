package postsystem.model;

import java.util.ArrayList;

public class Posts {
    public String title;
    public String body;
    public static ArrayList<Posts> posts = new ArrayList<Posts>();

    public Posts(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return  Posts.posts.indexOf(this)+1 + "번 게시글\n" +
                "제목: " + "[" + title + "]" + '\n' +
                "내용: " + "[" + body + "]" + '\n';
    }
}
