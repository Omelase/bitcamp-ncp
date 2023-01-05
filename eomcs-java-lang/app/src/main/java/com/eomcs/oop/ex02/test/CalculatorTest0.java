package com.eomcs.oop.ex02.test;

//# 관련된 기능(메서드)을 묶어 분류하기
//1) 분류 전
//2) 메서드를 클래스로 묶어 분류하기
//static class Calculator 생성, 계산 메서드 넣음
//3) 클래스 변수 도입
//class Calculator 내 static result 변수 옮김, 메서드에서 클래스 변수 사용
//4) 인스턴스 변수 도입
//result 변수를 인스턴스 변수로 변경, new명령으로 c1 레퍼런스 생성
//5) 인스턴스 메서드 활용
//6) 패키지 멤버 클래스로 분리
//class 파일 분리
//7) 클래스를 역할에 따라 패키지로 분류하기
//패키지로 분리하고 public 부여

public class CalculatorTest0 {

  public static void main(String[] args) {

    int result = 0;

    result = plus(2, 3);
    result = minus(result, 1);
    result = multiple(result, 7);
    result = divide(result, 3);

    System.out.printf("result = %d\n", result);
  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }
}
