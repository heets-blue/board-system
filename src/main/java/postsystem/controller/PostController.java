package postsystem.controller;

import postsystem.model.Posts;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostController {
    static Scanner input = new Scanner(System.in);

    public static void makePost() {
        System.out.println("\n게시글을 작성합니다.\n");
        System.out.print("제목: ");
        String title = input.nextLine();
        System.out.print("내용: ");
        String body = input.nextLine();
        Posts post = new Posts(title, body);
        Posts.posts.add(post);
        System.out.println("\n성공적으로 작성되었습니다.\n");
    }

    public static void deletePost() {
        if (Posts.posts.isEmpty()) {
            throw new NoSuchElementException("\n게시글이 존재하지 않습니다.\n");
        } else {
            System.out.println("\n마지막 게시글을 삭제합니다.\n");
            Posts.posts.removeLast();
        }
    }

    public static void showPosts() {
        if (Posts.posts.isEmpty()) {
            throw new NoSuchElementException("\n게시글이 존재하지 않습니다.\n");
        }else{
            System.out.println("\n게시글 목록을 조회합니다.\n");
            for (Posts post : Posts.posts) {
                System.out.println(post.toString());
            }
        }
    }

}
