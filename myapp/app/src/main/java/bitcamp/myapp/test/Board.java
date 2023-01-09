package bitcamp.myapp.test;

public class Board {
  int no;
  String title;
  String content;
  String password;
  String createdDate;
  int view; // 왜 view에 아무 값도 할당 안 했는데도 0으로 뜰까? 클래스필드와 인스턴스필드는 0으로 자동초기화됨
}