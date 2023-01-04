package com.eomcs.oop.ex02.test2;

import com.eomcs.oop.ex02.test.dto.Score;

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

public class OtherTest {

  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 85);
    printScore(s1);

    Score s2 = new Score("임꺽정", 90, 80, 75);
    printScore(s2);

    Score s3 = new Score("유관순" ,80, 70, 65);
    printScore(s3);
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}

