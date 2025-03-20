package postsystem.controller;

import postsystem.model.Posts;

import java.util.InputMismatchException;
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
        System.out.print("\n삭제 할 게시글 번호 > ");
        int postIndex = input.nextInt() - 1;

        if (!checkIdx(postIndex)) {
            notExistPostsException(postIndex);
        } else {
            System.out.printf("\n%d번 게시글을 삭제되었습니다.\n",postIndex+1);
            Posts.posts.remove(postIndex);
        }
    }

    public static void showPosts() {
        System.out.print("\n조회 할 게시글 번호 > ");
        int postIndex = input.nextInt() - 1;

        if(!checkIdx(postIndex)) {
            notExistPostsException(postIndex);
        }else{
            Posts post = Posts.posts.get(postIndex);
            System.out.printf("\n%d번 게시글을 조회합니다.\n",postIndex+1);
            System.out.println("\n"+post);
        }
    }

    public static void showAllPosts() {
        if (Posts.posts.isEmpty()) {
            throw new NoSuchElementException("게시글이 없습니다.");
        }
        System.out.printf("\n총 게시글은 %d개 작성되어있습니다.\n\n",Posts.posts.size());
        for(Posts post : Posts.posts){
            System.out.println(post);
        }
    }

    public static void editPost() {
        //int postIndex = isNotIntIdiot("수정");
        System.out.print("\n수정 할 게시글 번호 > ");
        int postIndex = input.nextInt() - 1;
        input.nextLine();
        if (!checkIdx(postIndex)) {
            notExistPostsException(postIndex);
        }else{
            System.out.printf("\n%d번 게시글을 수정합니다.\n",postIndex+1);
            Posts post = Posts.posts.get(postIndex);
            System.out.println("---기존 게시글 정보---");
            System.out.println(post.toString());
            System.out.print("새 제목: ");
            String newTitle = input.nextLine();
            System.out.print("새 내용: ");
            String newBody = input.nextLine();
            post.setTitle(newTitle);
            post.setBody(newBody);
            System.out.printf("\n%d번 게시글을 수정되었습니다.\n",postIndex+1);

        }
    }


    private static boolean checkIdx(int idx) {
        return idx >= 0 && idx < Posts.posts.size();
    }

    private static void notExistPostsException(int idx) {
        String em = String.format("""
                
                %d번 게시글은 존재하지 않습니다.
                """,idx+1);

        throw new NoSuchElementException(em);
    }

//    private static int isNotIntIdiot(String command) {
//        System.out.printf("\n%s 할 게시글 번호 > ",command);
//        try{
//            int postIndex = input.nextInt() - 1;
//            input.nextLine();
//            return postIndex;
//        }catch (InputMismatchException e){
//            throw new InputMismatchException("숫자를 입력하세요.");
//        }
//    }

}
