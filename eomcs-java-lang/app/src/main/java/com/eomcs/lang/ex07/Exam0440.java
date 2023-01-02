package com.eomcs.lang.ex07;

//# 메서드 : 스택 메모리 응용 I
//
public class Exam0440 {

  static int m1(int value) {
    int r1 = m2(value);
    int r2 = m3(value);
    return r1 + r2;
  }

  static int m2(int value) {
    return value + 100;
  }

  static int m3(int value) {
    return value + 200;
  }

  public static void main(String[] args) {
    int r = m1(5);
    System.out.println(r);
  }
}
// JVM Stack 메모리의 사용
// 0) 시작
// 1) main(args, r)
// 2) main(args, r) => m1(5, r1, r2)
// 3) main(args, r) => m1(5, r1, r2) => m2(5)
// 4) main(args, r) => m1(5, 105, r2)
// 5) main(args, r) => m1(5, 105, r2) => m3(5)
// 6) main(args, r) => m1(5, 105, 205)
// 7) main(args, 310)
// 8) 종료!