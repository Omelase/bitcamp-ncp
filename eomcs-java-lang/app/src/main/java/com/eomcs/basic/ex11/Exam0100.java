package com.eomcs.basic.ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// regex를 이용해 토큰단위로 끊는다.
public class Exam0100 {
  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("bit", Pattern.CASE_INSENSITIVE); // 대소문자 구분하지 않기
    Matcher matcher = pattern.matcher("the BitCamp");
    if (matcher.find()) {
      System.out.println("찾았다.");
    } else {
      System.out.println("못 찾았다.");
    }
    //    String str = "12+3*123-18/3+27";
    //
    //    String[] items = str.split("...");
    //
    //    for (String item : items) {
    //      System.out.println(item);
    //    }
  }
}
