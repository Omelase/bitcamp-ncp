package bitcamp.myapp;

public class App {

  public static void main(String[] args) {

    // 코드를 메서드로 분리했으면 호출하라!
    MemberHandler.inputMembers();

    System.out.println("---------------------------------------");

    // 코드를 메서드로 분리했으면 호출하라!
    MemberHandler.printMembers();
  } // main()
} // class App
