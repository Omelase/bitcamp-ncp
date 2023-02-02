package com.eomcs.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerApp3 {
  public static void main(String[] args) throws Exception {
    BufferedReader in = null;
    BufferedWriter out = null;
    ServerSocket serversocket = null;
    Socket socket = null;
    try {
      serversocket = new ServerSocket(8888); // 서버 소켓 생성
      System.out.println("연결을 기다리고 있습니다.....");
      socket = serversocket.accept(); // 클라이언트로부터 연결 요청 대기
      System.out.println("연결되었습니다.");
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      while (true) {
        String inputMessage = in.readLine();
        if (inputMessage.equalsIgnoreCase("quit")) {
          System.out.println("클라이언트에서 연결을 종료하였음");
          break; // "quit"을 받으면 연결 종료
        }
        System.out.println(inputMessage); // 받은 메시지를 화면에 출력
        String res = calc(inputMessage); // 계산. 계산 결과는 res
        out.write(res + "\n"); // 계산 결과 문자열 전송
        out.flush(); // 재사용을 위해 스트림을 비움
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (socket != null)
          socket.close(); // 통신용 소켓 닫기
        if (serversocket != null)
          serversocket.close(); // 서버 소켓 닫기
      } catch (IOException e) {
        System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
      }
    }
  }


  public static String calc(String exp) {
    StringTokenizer st = new StringTokenizer(exp, " ");
    if (st.countTokens() != 3)
      return "error";
    String res = "";
    double op1 = Double.parseDouble(st.nextToken());

    String opcode = st.nextToken();
    double op2 = Double.parseDouble(st.nextToken());

    switch (opcode) {
      case "+":
        res = Double.toString(Math.round((op1 + op2)*10)/10.0);
        break;
      case "-":
        res = Double.toString(Math.round((op1 - op2)*10)/10.0);
        break;
      case "*":
        res = Double.toString(Math.round((op1 * op2)*10)/10.0);
        break;
      case "/":
        if(op2 == 0) {
          res = "error";
          break;
        }
        res = Double.toString(Math.round((op1 / op2)*10)/10.0);
        break;
      default:
        res = "error";
    }
    return res;
  }
}

