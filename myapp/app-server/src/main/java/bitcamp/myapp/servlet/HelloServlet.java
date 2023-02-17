package bitcamp.myapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 클래스를 서블릿 컨테이너에 등록
// 클라이언트에서 /hello URL로 요청했을 때 이 클래스를 실행
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("HelloServlet.service() 호출");
  }
}
