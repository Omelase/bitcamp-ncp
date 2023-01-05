package bitcamp.myapp;

import java.sql.Date;

// 회원 데이터를 담을 메모리를 설계한다.
public class MemberHandler {
  // static으로 선언한 변수는 static멤버끼리 공유할 수 있다.
  static final int SIZE = 100;
  static int count = 0;

  // 레퍼런스 배열 준비
  static Member[] members = new Member[SIZE];
  /*
  // 필드
  static int[] no = new int[SIZE];
  static String[] name = new String[SIZE];
  static String[] tel = new String[SIZE];
  static String[] postNo = new String[SIZE];
  static String[] basicAddress = new String[SIZE];
  static String[] detailAddress = new String[SIZE];
  static boolean[] working = new boolean[SIZE];
  static char[] gender = new char[SIZE];
  static byte[] level = new byte[SIZE];
  static String[] createDate = new String[SIZE];
   */
  static void inputMember() {


    Member m = new Member();

    m.no = Prompt.inputInt("번호? ");

    m.name = Prompt.inputString("이름? ");

    m.tel = Prompt.inputString("전화번호? ");

    m.postNo = Prompt.inputString("우편번호? ");

    m.basicAddress = Prompt.inputString("주소? ");

    m.detailAddress = Prompt.inputString("상세주소? ");

    m.working = Prompt.inputInt("0. 미취업\n1. 재직중\n재직여부? ") == 1;

    m.gender = Prompt.inputInt("0. 남\n1. 여\n성별? ") == 0 ? 'M' : 'W';

    m.level = (byte) Prompt.inputInt("0. 비전공자\n1. 준전공자\n2. 전공자\n전공여부? "); // 0(비전공자), 1(준전공자), 2(전공자)

    m.createDate = new Date(System.currentTimeMillis()).toString();

    // 지금 금방 만든 객체에 사용자가 입력한 값을 저장한 후
    // 그 객체의 주소를 잃어버리지 않게 레퍼런스 배열에 보관해둔다.
    members[count++] = m;
  }

  static void printMembers() {
    System.out.println("번호\t이름\t전화\t재직\t전공");
    System.out.println("---------------------------------------");
    for (int i = 0; i < count; i++) {
      Member m = members[i];

      String levelTitle;
      switch (m.level) {
        case 0: levelTitle = "비전공자"; break;
        case 1: levelTitle = "준전공자"; break;
        default: levelTitle = "전공자";
      }

      System.out.printf("%d\t%s\t%s\t%s\t%s\n",
          m.no, m.name, m.tel,
          m.working ? "예" : "아니오",
              levelTitle);

      System.out.println("---------------------------------------");
    }
  }

  static void serevice() {
    while (true) {
      System.out.println("[회원관리]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전");
      int menuNo = Prompt.inputInt("회원관리> ");
  
      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        inputMember();
      } else if (menuNo == 2) {
        printMembers();
      } else if (menuNo >= 3 && menuNo <= 5) {
        System.out.println("작업실행!");
      } else {
        System.out.println("잘못된 메뉴 번호입니다.");
      }
    }
  }
}
