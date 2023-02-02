package com.eomcs.basic.ex11;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam110 {
  public static void main(String[] args) {
    // 1) 패턴 정의
    Pattern pattern = Pattern.compile("\\d+|\\D", Pattern.CASE_INSENSITIVE); // 대소문자 구분하지 않기
    // "." : 한자리씩
    // ".." : 두자리씩
    // "[0-9]" : 0에서 9까지 숫자가 있으면 반환
    // "[0-9]+" : 패턴검색을 반복하여 두자리 숫자가 있으면 반환
    // 2) 패턴에 따라 콘텐트를 검사할 도구 준비
    Matcher matcher = pattern.matcher("12+  3*123 -18/3+27");

    // 3) 패턴의 결과를 담을 컬렉션 준비
    ArrayList<String> items = new ArrayList<>();

    // 4) 패턴 검사
    while (matcher.find()) {
      // 5) 패턴과 일치하는 항목을 추출하여 컬렉션에 담기
      items.add(matcher.group());
    }

    System.out.println("------------------------");

    for (String item : items) {
      System.out.println(item);
    }
  }
}
