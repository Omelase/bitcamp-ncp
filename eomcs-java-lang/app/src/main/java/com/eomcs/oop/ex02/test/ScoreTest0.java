package com.eomcs.oop.ex02.test;

//0) 낱개 변수 사용
//1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
//class Score 생성하고 성적변수넣고 레퍼런스, 인스턴스 생성
//2) 리팩토링: 메서드 추출(extract method), static nested class
//class Score를 main 밖으로 빼내고 static 부여 후 성적계산, 출력 변수들을 printScore 메서드로 묶음
//3) 리팩토링: 메서드 추출(extract method) = 한 개의 메서드는 한 개의 기능을 수행해야 한다.
//printScore의 계산 기능을 compute로 따로 분리
//4) GRASP(General Responsibility Assignment Software Patterns) 패턴: Information Export
//5) 인스턴스 메서드: 인스턴스 주소를 받는 더 쉬운 문법
//compute의 static 제거
//6) 패키지 멤버 클래스:
//Score파일을 따로 분리하고 public 도입
//7) 클래스를 역할에 따라 패키지로 분류
//폴더를 따로 만들어 class Score 파일을 분리
//8) 생성자 도입: 인스턴스를 생성할 때 값을 초기화시키는 특별한 메서드

public class ScoreTest0 {
  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 90;
    math = 85;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "임꺽정";
    kor = 90;
    eng = 80;
    math = 75;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "유관순";
    kor = 80;
    eng = 70;
    math = 65;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
  }
}
