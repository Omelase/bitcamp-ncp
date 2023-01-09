package bitcamp.myapp.test;

public class App {

  public static void main(String[] args) {
    goMainMenu();
    System.out.println("안녕히 가세요!");

    Prompt.close();
  }

  private static void goMainMenu() {
    BoardHandler generalMemberHandler = new BoardHandler("일반회원");


    while (true) {
      System.out.println("1. 게시글 관리");
      System.out.println("9. 종료");
      int menuNo = Prompt.inputInt("메뉴> ");

      if (menuNo == 1) {
        generalMemberHandler.service();
      } else if (menuNo == 9) {
        break;
      } else {
        System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }

}