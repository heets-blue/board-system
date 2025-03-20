package postsystem.view;

import postsystem.controller.PostController;
import postsystem.model.Posts;

import java.util.Scanner;

public class PostView {
    public static void view(){
    Scanner input = new Scanner(System.in);
    while(true){
        String command;
        try {
            System.out.print("명령어 > ");
            command = input.nextLine();
            if (command.equals("종료")) {
                System.out.println("\n시스템을 종료합니다.\n");
                break;
            }
            if (command.equals("작성")) {
                PostController.makePost();

            } else if (command.equals("조회")) {
                PostController.showPosts();

            } else if (command.equals("삭제")) {
                PostController.deletePost();

            } else if (command.equals("수정")) {
                PostController.editPost();
            } else if (command.equals("목록")) {
                PostController.showAllPosts();
            } else {
                System.out.println("\n존재하지 않는 명령어입니다.\n");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
}
