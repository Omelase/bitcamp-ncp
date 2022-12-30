package bitcamp.myapp;

import java.sql.Date;

// 회원 데이터를 담을 메모리를 설계한다.
public class MemberHandler {
  // static으로 선언한 변수는 static멤버끼리 공유할 수 있다.
  static final int SIZE = 100;
  static int count = 0;

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

  static void inputMembers() {

    for (int i = 0; i < SIZE; i++) {

      no[i] = Prompt.inputInt("번호? ");

      name[i] = Prompt.inputString("이름? ");

      tel[i] = Prompt.inputString("전화번호? ");

      postNo[i] = Prompt.inputString("우편번호? ");

      basicAddress[i] = Prompt.inputString("주소? ");

      detailAddress[i] = Prompt.inputString("상세주소? ");

      working[i] = Prompt.inputInt("0. 미취업\n1. 재직중\n재직여부? ") == 1;

      gender[i] = Prompt.inputInt("0. 남\n1. 여\n성별? ") == 0 ? 'M' : 'W';

      level[i] = (byte) Prompt.inputInt("0. 비전공자\n1. 준전공자\n2. 전공자\n전공여부? "); // 0(비전공자), 1(준전공자), 2(전공자)

      createDate[i] = new Date(System.currentTimeMillis()).toString();

      count++;

      String str = Prompt.inputString("계속 입력하시겠습니까?(Y/N) ");
      if (!str.equalsIgnoreCase("Y") && str.length() != 0) {
        break;
      }
    }

    Prompt.close();
  }

  static void printMembers() {
    for (int i = 0; i < count; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("전화번호: %s\n", tel[i]);
      System.out.printf("우편번호: %s\n", postNo[i]);
      System.out.printf("주소: %s\n", basicAddress[i]);
      System.out.printf("상세주소: %s\n", detailAddress[i]);
      System.out.printf("재직여부: %s\n", working[i] ? "예" : "아니오");
      //      String workingLabel;
      //      if (working[i] == true) {
      //        workingLabel = "예";
      //      } else {
      //        workingLabel = "아니오";
      //      }
      //      System.out.printf("재직여부: %s\n", workingLabel);

      System.out.printf("성별: %s\n", gender[i] == 'M' ? "남" : "여");

      String levelTitle;
      switch (level[i]) {
        case 0: levelTitle = "비전공자"; break;
        case 1: levelTitle = "준전공자"; break;
        default: levelTitle = "전공자";
      }
      System.out.printf("전공레벨: %s\n", levelTitle);

      System.out.printf("가입날짜: %s\n", createDate[i]);

      System.out.println("---------------------------------------");
    }
  }
}
